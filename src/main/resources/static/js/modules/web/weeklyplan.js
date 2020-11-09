//获取页面高度的79%
var windowHeight = parseInt($(document).height()) * 0.81;
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'web/weeklyPlan/list',
        datatype: "json",
        colModel: [
            {label: '编号', name: 'weeklyPlanId', index: "weekly_plan_id", width: 80, key: true},
            {label: '班组', name: 'team', width: 110},
            {label: '日期', name: 'workDate', index: 'work_date', width: 115},
            {label: '星期', name: 'week', width: 135},
            {label: '项目编号', name: 'projectId', index: 'project_id', width: 135},
            {label: '项目名称', name: 'projectName', index: 'project_name', width: 180},
            {label: '主要工作内容', name: 'workContent', index: 'work_content', width: 500},
            {label: '停电设备名称', name: 'powerFailureEquipments', index: 'power_failure_equipments', width: 250},
            {label: '工作单位', name: 'workUnit', index: 'work_unit', width: 300},
            {label: '配合班组', name: 'cooperateTeam', index: 'cooperate_team', width: 100},
            {label: '项目分类', name: 'projectType', index: 'project_type', width: 100},
            {label: '停电时间', name: 'powerOffTime', index: 'power_off_time', width: 150},
            {label: '工作开始时间', name: 'startWorkTime', index: 'start_work_time', width: 100},
            {label: '工作结束时间', name: 'endWorkTime', index: 'end_work_time', width: 100},
            {label: '送电时间', name: 'powerInputingTime', index: 'power_inputing_time', width: 150},
            {label: '备注', name: 'remarks', width: 180},
            {label: '施工现场地址', name: 'constructionAddress', index: 'construction_address', width: 180},
            {label: '现场联系人', name: 'linkman', width: 80},
            {label: '联系人电话', name: 'telephone', width: 110},
            {label: '是否带视频监控', name: 'videoOrNot', index: 'video_or_not', width: 150},
            {label: '到岗人员', name: 'staff', width: 180}
        ],
        viewrecords: true,
        height: windowHeight,
        rowNum: 15,
        rowList: [15, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        shrinkToFit: false,
        autoScroll: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        }
        // gridComplete: function () {
        //     //隐藏grid底部滚动条
        //     $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        // }
    });

    new AjaxUpload('#upload', {
        action: baseURL + 'web/weeklyPlan/import?token=' + token,
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(xls|xlsx)$/.test(extension.toLowerCase()))) {
                alert('只支持excel格式！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r.code == 0) {
                alert(r.msg);
                vm.reload();
            } else {
                alert(r.msg);
            }
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            projectId: null,
            workDate: null,
            workUnit: null
        },
        showList: true,
        title: null,
        roleList: {},
        user: {
            status: 1,
            roleIdList: []
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        del: function () {
            var weeklyPlanIds = getSelectedRows();
            if (weeklyPlanIds == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "web/weeklyPlan/delete",
                    contentType: "application/json",
                    data: JSON.stringify(weeklyPlanIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function () {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        reload: function () {
            vm.showList = true;
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'projectId': vm.q.projectId,
                    "workDate": vm.q.workDate,
                    "workUnit": vm.q.workUnit
                },
                page: 1
            }).trigger("reloadGrid");
        }
    }
});