layui.use('table', function() {
	var table = layui.table;

	//展示已知数据
	table.render({
		elem: '#demo',
		cols: [
			[ //标题栏
				{
					type: 'checkbox',
					fixed: 'left'
				},
				{
					field: 'id',
					title: '序号',
					width: 80,
					unresize: 'false',
					sort: true
				}, {
					field: 'Quanzong_number',
					title: '全宗号',
					width: 100,
					unresize: 'false',
				}, {
					field: 'Quanzong_name',
					title: '全宗名称',
					minWidth: 100,
					unresize: 'false',
				}, {
					field: 'Box_anual',
					title: '年度',
					Width: 100,
					unresize: 'false',
				}, {
					field: 'Organization_id',
					title: '机构(问题)',
					width: 150,
					unresize: 'false',
				},
				{
					field: 'Retentionperiod_id',
					title: '保管期限',
					width: 100,
					unresize: 'false',
				},
				{
					field: 'Box_startnumber',
					title: '起件号',
					width: 100,
					unresize: 'false',
				},
				{
					field: 'Box_endnumber',
					title: '止件号',
					width: 100,
					unresize: 'false',
				},
				{
					field: 'Box_number',
					title: '盒号',
					width: 100,
					unresize: 'false',
				},
				{
					field: 'Box_thickness',
					title: '盒属性',
					width: 100,
					unresize: 'false',
				},
				{
					field: 'BOX_AUDITSTART',
					title: '状态',
					width: 100,
					unresize: 'false',
				},
				{
					field: 'right',
					title: '操作',
					width: 100,
					unresize: 'false',
					toolbar: '#barDemo'
				}
			]
		],
		data: [{
				"id": "1",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "2",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "3",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "4",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "5",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "6",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "7",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "8",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "9",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "10",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "11",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, {
				"id": "12",
				"Quanzong_number": "021",
				"Quanzong_name": "某某市安监局",
				"Box_anual": "2017",
				"Organization_id": "办公室",
				"Retentionperiod_id": "永久",
				"Box_startnumber": "0001",
				"Box_endnumber": "0005",
				"Box_number": "1",
				"Box_thickness": "2cm",
				"BOX_AUDITSTART": "待审核",
			}, ]
			//,skin: 'line' //表格风格
			,
		even: true,
		page: true //是否显示分页
			//,limits: [5, 7, 10]
			,
		limit: 12 //每页默认显示的数量
	});
	//监听工具条
	table.on('tool(demo)', function(obj) {
		var data = obj.data;
		var tr = obj.tr;

		if(obj.event === 'detail') {
			//			      layer.msg('ID：'+ data.id + ' 的查看操作');
			layer.open({
				type: 1,
				title: '<i class="fa fa-bars" style="padding:0 5px"></i>查看',
				area: ['800px', '460px'],
				skin: 'add_label_bg',
				offset: 'auto',
				shade: [0.8, '#393D49'],
				content: '<div class="add_lb1">' +
					'<ul class="look-list">' +
					'<li>盒面&盒脊</li>' +
					'<li>归档文件目录</li>' +
					'<li>文件</li>' +
					'<li>备考表</li>' +
					'</ul>' +
					'<div id="">' +
					'<div style="float: left;"><img src="../imgs/box.jpg" width="150px" height="200" style="padding: 20px;" class="imgs"/></div>' +
					'<div style="float: left;"><img src="../imgs/guidang.png" class="guidang" width="150px" height="200" style="padding: 20px;"/></div>' +
					'<div style="float: left;"><img src="../imgs/wenjian.png" class="wenjian" width="150px" height="200" style="padding: 20px;"/></div>' +
					'<div style="float: left;"><img src="../imgs/beikao.png" width="150px" height="200" style="padding: 20px;"class="imgs" /></div>' +
					'<div class="layui-clear" style="padding-top: 30px;padding-left: 350px;"><span>第<select name=""><option value="">1</option></select>件</span>' +
					'<span>共<span>12</span>件</span><span class="layui-btn layui-btn-xs">上一件</span><span class="layui-btn layui-btn-xs">下一件</span></div></div></div>'
			});
			$(function() {
				$('.imgs').viewer();
			})
			//查看文件列表
			$(function() {
				$(".wenjian").click(function() { //#btn为按钮id
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>文件列表',
						area: ['800px', '400px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: '<ul class="Scanning_Images" onclick="img_vi()"><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li><li><img src="../imgs/page1.jpg" alt=""><p>page1</p></li></ul>'
					});
				})
			})
			$(function() {
				$(".guidang").click(function() { //#btn为按钮id
					layer.open({
						type: 1,
						title: '<i class="fa fa-bars" style="padding:0 5px"></i>归档文件列表',
						area: ['800px', '600px'],
						skin: 'add_label_bg',
						offset: 'auto',
						shade: [0.8, '#393D49'],
						content: '<div style="padding: 15px;"><ul class="table_title"><li><label>期限</label><span>10年</span></li><li><label>分类</label><span>综合科</span></li><li><label>盒号</label><span>61</span></li></ul><table class="layui-hide" id="guidang" lay-filter="guidang"></table></div>'
					});
					layui.use('table', function() {
						var table = layui.table;

						//展示已知数据
						table.render({
							elem: '#guidang',
							cols: [
								[ //标题栏
									{
										field: 'Archivefile_filenumber',
										title: '档号',
										width: 150,
										unresize: 'false',
									}, {
										field: 'Archivefile_referencenumber',
										title: '文号',
										minwidth: 200,
										unresize: 'false',
									}, {
										field: 'Archivefile_responsible',
										title: '责任人',
										Width: 100,
										unresize: 'false',
									}, {
										field: 'Archivefile_title',
										title: '题名',
										Width: 100,
										unresize: 'false',
									},
									{
										field: 'Archivefile_createtime',
										title: '日期',
										Width: 100,
										unresize: 'false',
									},
									{
										field: 'Archivefile_securityclassrification',
										title: '密级',
										Width: 100,
										unresize: 'false',
									},
									{
										field: 'Archivefile_pages',
										title: '页数',
										Width: 100,
										unresize: 'false',
									},
									{
										field: 'Archivefile_remark',
										title: '备注',
										Width: 100,
										unresize: 'false',
									},

								]
							],
							data: [{
									"Archivefile_filenumber": "109-WS•2016-Y-BGS-0002",
									"Archivefile_referencenumber": "甘档发〔2016〕**号",
									"Archivefile_responsible": "甘肃省档案局",
									"Archivefile_title": "甘肃省档案局关于********的批复 [及请示]",
									"Archivefile_createtime": "20170605",
									"Archivefile_securityclassrification": "机密",
									"Archivefile_pages": "20",
									"Archivefile_remark": ".......",
								}, {
									"Archivefile_filenumber": "109-WS•2016-Y-BGS-0002",
									"Archivefile_referencenumber": "甘档发〔2016〕**号",
									"Archivefile_responsible": "甘肃省档案局",
									"Archivefile_title": "甘肃省档案局关于********的批复 [及请示]",
									"Archivefile_createtime": "20170605",
									"Archivefile_securityclassrification": "机密",
									"Archivefile_pages": "20",
									"Archivefile_remark": ".......",
								}, {
									"Archivefile_filenumber": "109-WS•2016-Y-BGS-0002",
									"Archivefile_referencenumber": "甘档发〔2016〕**号",
									"Archivefile_responsible": "甘肃省档案局",
									"Archivefile_title": "甘肃省档案局关于********的批复 [及请示]",
									"Archivefile_createtime": "20170605",
									"Archivefile_securityclassrification": "机密",
									"Archivefile_pages": "20",
									"Archivefile_remark": ".......",
								}, {
									"Archivefile_filenumber": "109-WS•2016-Y-BGS-0002",
									"Archivefile_referencenumber": "甘档发〔2016〕**号",
									"Archivefile_responsible": "甘肃省档案局",
									"Archivefile_title": "甘肃省档案局关于********的批复 [及请示]",
									"Archivefile_createtime": "20170605",
									"Archivefile_securityclassrification": "机密",
									"Archivefile_pages": "20",
									"Archivefile_remark": ".......",
								}, {
									"Archivefile_filenumber": "109-WS•2016-Y-BGS-0002",
									"Archivefile_referencenumber": "甘档发〔2016〕**号",
									"Archivefile_responsible": "甘肃省档案局",
									"Archivefile_title": "甘肃省档案局关于********的批复 [及请示]",
									"Archivefile_createtime": "20170605",
									"Archivefile_securityclassrification": "机密",
									"Archivefile_pages": "20",
									"Archivefile_remark": ".......",
								}, {
									"Archivefile_filenumber": "109-WS•2016-Y-BGS-0002",
									"Archivefile_referencenumber": "甘档发〔2016〕**号",
									"Archivefile_responsible": "甘肃省档案局",
									"Archivefile_title": "甘肃省档案局关于********的批复 [及请示]",
									"Archivefile_createtime": "20170605",
									"Archivefile_securityclassrification": "机密",
									"Archivefile_pages": "20",
									"Archivefile_remark": ".......",
								}, {
									"Archivefile_filenumber": "109-WS•2016-Y-BGS-0002",
									"Archivefile_referencenumber": "甘档发〔2016〕**号",
									"Archivefile_responsible": "甘肃省档案局",
									"Archivefile_title": "甘肃省档案局关于********的批复 [及请示]",
									"Archivefile_createtime": "20170605",
									"Archivefile_securityclassrification": "机密",
									"Archivefile_pages": "20",
									"Archivefile_remark": ".......",
								}, ]
								//,skin: 'line' //表格风格
								,
							even: true,
							page: true //是否显示分页
								//,limits: [5, 7, 10]
								,
							limit: 7 //每页默认显示的数量
						});
					});
				})
			})

		}
	});
});

function img_vi() {
	$('.Scanning_Images').viewer();
}

$(function() {
	$(".file_boxes").click(function() { //#btn为按钮id
		layer.open({
			type: 1,
			title: '<i class="fa fa-bars" style="padding:0 5px"></i>驳回重整',
			area: ['800px', '600px'],
			skin: 'add_label_bg',
			offset: 'auto',
			shade: [0.8, '#393D49'],
			content: '<div style="padding: 15px;text-align: center;"><label style="font-weight: bold;">验收情况表</label><table class="layui-hide" id="text" lay-filter="text"></table> </div><div style="text-align: center;margin:5px;"><button class="layui-btn btn_color">确定</button></div></form>'
		});
		layui.use('table', function() {
			var table = layui.table;

			//展示已知数据
			table.render({
				elem: '#text',
				cols: [
					[ //标题栏
						{
							field: 'audit-id',
							title: '抽查盒编号',
							width: 150,
							unresize: 'false',
						}, {
							field: 'audit-number',
							title: '存在问题',
							minwidth: 200,
							unresize: 'false',
							edit: 'text',
						}, {
							field: 'audit-pel',
							title: '审核人',
							Width: 100,
							unresize: 'false',
						}, {
							field: 'audit-time',
							title: '审核时间',
							Width: 100,
							unresize: 'false',
						},

					]
				],
				data: [{
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						},
						{
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						}, {
							"audit-id": "021-2017-Y-1",
							"audit-number": "请点击编辑",
							"audit-pel": "张益达",
							"audit-time": "2017-06-05",
						},
					]
					//,skin: 'line' //表格风格
					,
				even: true,
				page: false //是否显示分页
					//,limits: [5, 7, 10]
					,
				limit: 20 //每页默认显示的数量
			});
		});
	})
})