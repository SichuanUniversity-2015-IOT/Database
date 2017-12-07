
jQuery(document).ready(function() {  
	
   // initiate layout and plugins
   Metronic.init(); // init metronic core components
   Layout.init(); // init current layout
   QuickSidebar.init(); // init quick sidebar
   Demo.init(); // init demo features
   Profile.init(); // init page demo
   Record.init();
});

var Record = function(){
	var classId = undefined;
	var className = undefined;
	var id = undefined;
	
	var initRecordList = function(){
		getRecord();
	}
	
	var handleButtonEvent = function(){
		$('#submit_button').click(function() {Record.submitRecord();});
		$('#back_button').click(function() {Record.back();});
		$('#change_button').click(function(){Record.change()});
		$('#charts_button').click(function(){Record.charts()});
		$('#add_button').click(function(){Record.add()});
	}
	
	var submitRecord = function(){
		search_form.action="teacherSearch.jsp";
		search_form.submit();
	}
	
	
	var getRecord = function(){
		
		$.post("../../alluserQuery",{},function(data){
			
			var html="";
			var userData = eval("("+data+")");
			var teacherList = eval(userData.teacherList);
			
			for(var i=0;i<teacherList.length;i++){
				var tName = teacherList[i].tName;
				var tID = teacherList[i].tID;
				html=html+"										<!-- BEGIN FORM-->";
				html=html+"										<form action=\"teacherInformation.jsp\" class=\"form-horizontal\">";
				html=html+"											<div class=\"form-body\">";
				html=html+"												<div class=\"form-group\">";
				html=html+"												<div class=\"row\">";
				html=html+"													<label class=\"col-md-3 control-label\">ID: "+ tID +"</label>";
				html=html+"													<div class=\"col-md-4\">";
				html=html+"														<p type=\"text\" class=\"form-control input-circle\" placeholder=\"Enter text\">";
				html=html+"														<span class=\"help-block\">";
				html=html+"														"+tName+"</span>";
				html=html+"													</div>";
				html=html+"														<input type=\"hidden\" name=\"tID\" value=\""+tID+"\">";
				html=html+"														<button type=\"submit\" class=\"btn btn-circle blue\">查看详细</button>";
				html=html+"														<button type=\"button\" class=\"btn btn-circle default\" onclick=\"window.location='teacherDelete.jsp?id="+tID+"'\">删除</button>";
				html=html+"												</div>";
				html=html+"												</div>";
				html=html+"											</div>";
				html=html+"										</form>";
				html=html+"										<hr></hr>";
				html=html+"										<!-- END FORM-->";
				}
			document.getElementById("class_nav").innerHTML=html;
		});
	}
	return {
		init: function(){
			initRecordList();
			handleButtonEvent();
		},
		back: function(){
			window.location="personal_center.jsp";
		},
		submitRecord: function(){
			submitRecord();
		},
		change: function(){
			window.location="studentList.jsp";
		},
		charts: function(){
			window.location="userChart.jsp";
		},
		add: function(){
			window.location="teacherAdd.jsp";
		}
	}
}();