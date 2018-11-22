
(function () {
	'use strict';

	var byId = function (id) { return document.getElementById(id); },

		loadScripts = function (desc, callback) {
			var deps = [], key, idx = 0;

			for (key in desc) {
				deps.push(key);
			}

			(function _next() {
				var pid,
					name = deps[idx],
					script = document.createElement('script');

				script.type = 'text/javascript';
				script.src = desc[deps[idx]];

				pid = setInterval(function () {
					if (window[name]) {
						clearTimeout(pid);

						deps[idx++] = window[name];

						if (deps[idx]) {
							_next();
						} else {
							callback.apply(null, deps);
						}
					}
				}, 30);

				document.getElementsByTagName('head')[0].appendChild(script);
			})()
		},

		console = window.console;


	if (!console.log) {
		console.log = function () {
			alert([].join.apply(arguments, ' '));
		};
	}

	Sortable.create(byId('foo'), {
		group: "words",
		animation: 150,
		store: {
			get: function (sortable) {
				var order = localStorage.getItem(sortable.options.group);
				return order ? order.split('|') : [];
			},
			set: function (sortable) {
				var order = sortable.toArray();
				localStorage.setItem(sortable.options.group, order.join('|'));
			}
		},
		onAdd: function (evt){ 
			
		},
		onUpdate: function (evt){ console.log('onUpdate.foo:', [evt.item, evt.from]); },
		onRemove: function (evt){ console.log('onRemove.foo:', [evt.item, evt.from]); },
		onStart:function(evt){ console.log('onStart.foo:', [evt.item, evt.from]);},
		onSort:function(evt){ console.log('onStart.foo:', [evt.item, evt.from]);},
		onEnd: function(evt){ console.log('onEnd.foo:', [evt.item, evt.from]);}
	});
	
	
	Sortable.create(byId('barTwo'), {
		group: "words",
		animation: 150,
		onAdd: function (evt){ 
			 var archiveFileId=evt.item.children[0].value;
			  layer.confirm('您确定将该文件放入回收站吗？', {
				  btn: ['确定', '取消'] //可以无限个按钮
				}, function(index, layero){
					$.ajax({
						  url:"/filemanage/knowledgeBase/updateFileStatus3",
						  type:"post",
						  data:{"archiveFileId":archiveFileId,"archiveFileAuthenticateStatus":3,"archiveFileFinishingStatus":3},
						  dataType:"text",
						  success:function(data){
							  if(data=="true"){
								  layer.msg("文件状态已更改为回收状态!",{offset:'auto',time:1500},function(){
									  queryImgByAnual2();
									})
							  }else if(data=="false"){
								  layer.msg("文件状态更改失败，请重试");
							  }
						  },
   
					  });
				}, function(index){
					var status=$("#file").val();
					if(status=="1"){
						var currentPage=$("#pageNum").val();
						common_getPicFileList(currentPage);
					}else if(status=="2"){
						var currentPage=$("#pageNum2").val();
						common_getPicFileList2(currentPage);
					}else if(status=="3"){
						var currentPage=$("#pageNum3").val();
						common_getPicFileList3(currentPage);
					}
				});  
			 
		  },
		
		onUpdate: function (evt){  
		},
		onRemove: function (evt){ 
			 
		},
		onStart:function(evt){ 
			
		},
		onEnd: function(evt){ 
			
		}
	});
	
	
	
	Sortable.create(byId('bar'), {
		group: "words",
		animation: 150,
		onAdd: function (evt){  
		  var archiveFileId=evt.item.children[0].value;
		  layer.confirm('您确定将该文件放入待整理文件吗？', {
			  btn: ['确定', '取消'] //可以无限个按钮
			}, function(index, layero){
				$.ajax({
					  url:"/filemanage/knowledgeBase/updateFileStatus2",
					  type:"post",
					  data:{"archiveFileId":archiveFileId,"archiveFileAuthenticateStatus":2,"archiveFileFinishingStatus":2},
					  dataType:"text",
					  success:function(data){
						  if(data=="true"){
							  layer.msg("文件状态已更改为待整理状态",{offset:'auto',time:1500},function(){
								
								    queryImgByAnual2();
								    
								})
							  
						  }else if(data=="false"){
							  layer.msg("文件状态更改失败，请重试");
						  }
					  },  
				  });
			}, function(index){
				var status=$("#file").val();
				if(status=="1"){
					var currentPage=$("#pageNum").val();
					common_getPicFileList(currentPage);
				}else if(status=="2"){
					var currentPage=$("#pageNum2").val();
					common_getPicFileList2(currentPage);
				}else if(status=="3"){
					var currentPage=$("#pageNum3").val();
					common_getPicFileList3(currentPage);
				}
				
			});  
		      
		  },
		
		onUpdate: function (evt){ 
			 
		},
		onRemove: function (evt){ 
			
		},
		onStart:function(evt){ 
			
		},
		onEnd: function(evt){ 
			
		}
	});
	
	
 

	
	// Multi groups
	Sortable.create(byId('multi'), {
		animation: 150,
		draggable: '.tile',
		handle: '.tile__name'
	});

	[].forEach.call(byId('multi').getElementsByClassName('tile__list'), function (el){
		Sortable.create(el, {
			group: 'photo',
			animation: 150
		});
	});


	// Editable list
	var editableList = Sortable.create(byId('editable'), {
		animation: 150,
		filter: '.js-remove',
		onFilter: function (evt) {
			evt.item.parentNode.removeChild(evt.item);
		}
	});


	byId('addUser').onclick = function () {
		Ply.dialog('prompt', {
			title: 'Add',
			form: { name: 'name' }
		}).done(function (ui) {
			var el = document.createElement('li');
			el.innerHTML = ui.data.name + '<i class="js-remove">✖</i>';
			editableList.el.appendChild(el);
		});
	};


	// Advanced groups
	[{
		name: 'advanced',
		pull: true,
		put: true
	},
	{
		name: 'advanced',
		pull: 'clone',
		put: false
	}, {
		name: 'advanced',
		pull: false,
		put: true
	}].forEach(function (groupOpts, i) {
		Sortable.create(byId('advanced-' + (i + 1)), {
			sort: (i != 1),
			group: groupOpts,
			animation: 150
		});
	});


	// 'handle' option
	Sortable.create(byId('handle-1'), {
		handle: '.drag-handle',
		animation: 150
	});


	// Angular example
	angular.module('todoApp', ['ng-sortable'])
		.constant('ngSortableConfig', {onEnd: function() {
			console.log('default onEnd()');
		}})
		.controller('TodoController', ['$scope', function ($scope) {
			$scope.todos = [
				{text: 'learn angular', done: true},
				{text: 'build an angular app', done: false}
			];

			$scope.addTodo = function () {
				$scope.todos.push({text: $scope.todoText, done: false});
				$scope.todoText = '';
			};

			$scope.remaining = function () {
				var count = 0;
				angular.forEach($scope.todos, function (todo) {
					count += todo.done ? 0 : 1;
				});
				return count;
			};

			$scope.archive = function () {
				var oldTodos = $scope.todos;
				$scope.todos = [];
				angular.forEach(oldTodos, function (todo) {
					if (!todo.done) $scope.todos.push(todo);
				});
			};
		}])
		.controller('TodoControllerNext', ['$scope', function ($scope) {
			$scope.todos = [
				{text: 'learn Sortable', done: true},
				{text: 'use ng-sortable', done: false},
				{text: 'Enjoy', done: false}
			];

			$scope.remaining = function () {
				var count = 0;
				angular.forEach($scope.todos, function (todo) {
					count += todo.done ? 0 : 1;
				});
				return count;
			};

			$scope.sortableConfig = { group: 'todo', animation: 150 };
			'Start End Add Update Remove Sort'.split(' ').forEach(function (name) {
				$scope.sortableConfig['on' + name] = console.log.bind(console, name);
			});
		}]);
})();

// Background
document.addEventListener("DOMContentLoaded", function () {
	function setNoiseBackground(el, width, height, opacity) {
		var canvas = document.createElement("canvas");
		var context = canvas.getContext("2d");

		canvas.width = width;
		canvas.height = height;

		for (var i = 0; i < width; i++) {
			for (var j = 0; j < height; j++) {
				var val = Math.floor(Math.random() * 255);
				context.fillStyle = "rgba(" + val + "," + val + "," + val + "," + opacity + ")";
				context.fillRect(i, j, 1, 1);
			}
		}

		el.style.background = "url(" + canvas.toDataURL("image/png") + ")";
	}

	setNoiseBackground(document.getElementsByTagName('body')[0], 50, 50, 0.02);
}, false);





























