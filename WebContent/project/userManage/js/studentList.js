
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
	}
	
	var submitRecord = function(){
		search_form.action="userSearch.jsp";
		search_form.submit();
	}
	
	
	var getRecord = function(){
		$.post("../../alluserQuery",{},function(data){
			var html="";
			var userData = eval("("+data+")");
			//alert(userData);
			var studentList = eval(userData.studentList);
			
			for(var i=0;i<studentList.length;i++){
				var sName = studentList[i].sName;
				var sID = studentList[i].sID;
				
				html=html+"								<div class=\"portlet box green\">";
				html=html+"									<div class=\"portlet-title\">";
				html=html+"										<div class=\"caption\">";
				html=html+"											<i class=\"fa fa-gift\"></i>ID:"+sID;
				html=html+"										</div>";
				html=html+"									</div>";
				html=html+"									<div class=\"portlet-body form\">";
				html=html+"										<!-- BEGIN FORM-->";
				html=html+"										<form action=\"userInformation.jsp\" class=\"form-horizontal\">";
				html=html+"											<div class=\"form-body\">";
				html=html+"												<div class=\"form-group\">";
				html=html+"													<label class=\"col-md-3 control-label\">用户名：</label>";
				html=html+"													<div class=\"col-md-4\">";
				html=html+"														<p type=\"text\" class=\"form-control input-circle\" placeholder=\"Enter text\">";
				html=html+"														<span class=\"help-block\">";
				html=html+"														"+sName+"</span>";
				html=html+"													</div>";
				html=html+"												</div>";
				html=html+"											</div>";
				html=html+"											<div class=\"form-actions\">";
				html=html+"												<div class=\"row\">";
				html=html+"													<div class=\"col-md-offset-3 col-md-9\">";
				html=html+"														<input type=\"hidden\" name=\"id\" value=\""+sID+"\">";
				html=html+"														<button type=\"submit\" class=\"btn btn-circle blue\">查看详细</button>";
				html=html+"														<button type=\"button\" class=\"btn btn-circle default\" onclick=\"window.location='userDelete.jsp?id="+sID+"'\">删除</button>";
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
		submitRecord: function(){
			submitRecord();
		},
		change:function(){
			window.location="teacherList.jsp";
		}
	}
}();