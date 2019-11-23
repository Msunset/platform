$(function () {
    $("#jqGrid").Grid({
        url: '../shopaudit/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '店铺名称', name: 'shopname', index: 'shopname', width: 80},
			{label: '店铺申请经营类目,可以选择多类别', name: 'type', index: 'type', width: 80},
			{label: '企业或个体户营业执照', name: 'business', index: 'business', width: 80},
			{label: '商标或品牌商业授权', name: 'brand', index: 'brand', width: 80},
			{label: '特殊行业资质上传', name: 'aptitude', index: 'aptitude', width: 80},
			{label: '商铺管理者姓名', name: 'adminname', index: 'adminname', width: 80},
			{label: '联系方式', name: 'phone', index: 'phone', width: 80},
			{label: '邮箱', name: 'email', index: 'email', width: 80},
			{label: '店铺审核状态，0代表未审核，1代表审核处理中，2代表审核失败，3代表审核通过', name: 'state', index: 'state', width: 80},
			{label: '申请审核时间', name: 'creattime', index: 'creatTime', width: 80},
			{label: '用户登录的id唯一标识 ', name: 'userid', index: 'userId', width: 80},
			{label: '身份证号', name: 'idcard', index: 'idcard', width: 80},
			{label: '身份证图片', name: 'idcardimage', index: 'idcardImage', width: 80},
			{label: '店铺账号', name: 'shopAccount', index: 'shop_account', width: 80},
			{label: '店铺账号密码', name: 'password', index: 'password', width: 80}]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		shopaudit: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.shopaudit = {};
		},
		update: function (event) {
            let id = getSelectedRow("#jqGrid");
			if (id == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
            let url = vm.shopaudit.id == null ? "../shopaudit/save" : "../shopaudit/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.shopaudit),
                type: "POST",
			    contentType: "application/json",
                successCallback: function (r) {
                    alert('操作成功', function (index) {
                        vm.reload();
                    });
                }
			});
		},
		del: function (event) {
            let ids = getSelectedRows("#jqGrid");
			if (ids == null){
				return;
			}

			confirm('确定要删除选中的记录？', function () {
                Ajax.request({
				    url: "../shopaudit/delete",
                    params: JSON.stringify(ids),
                    type: "POST",
				    contentType: "application/json",
                    successCallback: function () {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
					}
				});
			});
		},
		getInfo: function(id){
            Ajax.request({
                url: "../shopaudit/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.shopaudit = r.shopaudit;
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
		},
        reloadSearch: function() {
            vm.q = {
                name: ''
            }
            vm.reload();
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
	}
});