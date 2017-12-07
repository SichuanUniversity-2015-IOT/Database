
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
	}
	
	var submitRecord = function(){
		search_form.action="courseSearch.jsp";
		search_form.submit();
	}
	
	
	var getRecord = function(){
		
		$.post("../../allcourseQuery",{},function(data){
			var html="";
			
			//解析json
			var courseData=eval("("+data+")"); 
			//alert(courseData);
			var courseList = eval(courseData.courseList);
			
			for(var i=0;i<courseList.length;i++){
				var cName = courseList[i].cName;
				//alert(className);
				var cID = courseList[i].cID;
				//alert(cID);
				html=html+"								<div class=\"portlet box green\">";
				html=html+"									<div class=\"portlet-title\">";
				html=html+"										<div class=\"caption\">";
				html=html+"											<i class=\"fa fa-gift\"></i>ID:"+cID;
				html=html+"										</div>";
				html=html+"									</div>";
				html=html+"									<div class=\"portlet-body form\">";
				html=html+"										<!-- BEGIN FORM-->";
				html=html+"										<form action=\"courseInformation.jsp\" class=\"form-horizontal\">";
				html=html+"											<div class=\"form-body\">";
				html=html+"												<div class=\"form-group\">";
				html=html+"													<label class=\"col-md-3 control-label\">课程名：</label>";
				html=html+"													<div class=\"col-md-4\">";
				html=html+"														<p type=\"text\" class=\"form-control input-circle\" placeholder=\"Enter text\">";
				html=html+"														<span class=\"help-block\">";
				html=html+"														"+cName+"</span>";
				html=html+"													</div>";
				html=html+"												</div>";
				html=html+"											</div>";
				html=html+"											<div class=\"form-actions\">";
				html=html+"												<div class=\"row\">";
				html=html+"													<div class=\"col-md-offset-3 col-md-9\">";
				html=html+"														<input type=\"hidden\" name=\"cID\" value=\""+cID+"\">";
				html=html+"														<button type=\"submit\" class=\"btn btn-circle blue\">查看详细</button>";
				html=html+"														<button type=\"button\" class=\"btn btn-circle default\" onclick=\"window.location='courseDelete.jsp?cID="+cID+"'\">删除</button>";
				html=html+"													</div>";
				html=html+"												</div>";
				html=html+"											</div>";
				html=html+"										</form>";
				html=html+"										<!-- END FORM-->";
				html=html+"									</div>";
				html=html+"								</div>";
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
		charts: function(){
			window.location="courseChart.jsp";
		}
	}
}();