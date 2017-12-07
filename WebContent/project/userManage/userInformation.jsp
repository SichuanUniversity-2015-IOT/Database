<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.text.*,org.json.JSONObject,org.json.JSONArray,java.util.List"%>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.5
Version: 4.1.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!-- BEGIN HEAD -->
	<head>
		<meta charset="utf-8"/>
		<title>720度课堂</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<meta content="" name="description"/>
		<meta content="" name="author"/>
		<!-- BEGIN GLOBAL MANDATORY STYLES -->
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
		<link href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
		<!-- END GLOBAL MANDATORY STYLES -->
		<!-- BEGIN PAGE LEVEL STYLES -->
		<link href="../../assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/admin/pages/css/profile.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
		<!-- END PAGE LEVEL STYLES -->
		<!-- BEGIN THEME STYLES -->
		<link href="../../assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
		<link href="../../assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
		<link id="style_color" href="../../assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css"/>
		<link href="../../assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
		<!-- END THEME STYLES -->
		<link rel="shortcut icon" href="favicon.ico"/>
	</head>
	<!-- END HEAD -->
	<!-- BEGIN BODY -->
	<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed page-sidebar-closed-hide-logo page-container-bg-solid" onload="initPage()">
		<% 	String id=request.getParameter("id");
			int idInt = Integer.parseInt(id);
			String model=(String)session.getAttribute("model");
			int pretID = -1;
			int nexttID = -1;
			int presID = -1;
			int nextsID = -1;
			
			JSONObject userData = null;
			if(session.getAttribute("userData")!=null){
				System.out.println("session not empty!" + session.getAttribute("userData"));
				userData= new JSONObject((String)session.getAttribute("userData"));
				System.out.println("get userData!" + userData);
			}
			
			if(model.equals("teacher")){
				JSONArray teacherList=userData.getJSONArray("teacherList");
				int totalCount = teacherList.length();
				for(int i=0;i<totalCount;i++) {
					JSONObject teacherInfo = teacherList.getJSONObject(i);
					int temptID = teacherInfo.getInt("tID");
					if(temptID == idInt){
						if(i!=0)
							pretID = teacherList.getJSONObject(i-1).getInt("tID");
					
						if(i!=totalCount-1)
							nexttID = teacherList.getJSONObject(i+1).getInt("tID");
					}
				}
			}else{
				JSONArray studentList=userData.getJSONArray("studentList");
				int totalCount = studentList.length();
				for(int i=0;i<totalCount;i++) {
					JSONObject studentInfo = studentList.getJSONObject(i);
					int tempsID = studentInfo.getInt("sID");
					if(tempsID == idInt){
						if(i!=0)
							presID = studentList.getJSONObject(i-1).getInt("sID");
					
						if(i!=totalCount-1)
							nextsID = studentList.getJSONObject(i+1).getInt("sID");
					}
				}
			}
			
			
			
		%>
		
		
		<div class="clearfix">
		</div>
		<!-- BEGIN CONTAINER -->
		<div class="page-container">
			
			<!-- BEGIN CONTENT -->
	
		<div class="page-content">
			<%@ include file="personalCenter/personal_center_page_header.jsp"%>
			
			<div class="row margin-top-20">
				<div class="col-md-12">
					<div class="row">
						<%@ include file="sideBar.jsp" %>
						<div class="col-md-8 col-sm-8">
								<nav id="class_nav">
					
								</nav>
						</div>
				</div>
				
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
		</div>
		<!-- END CONTAINER -->
		<!-- BEGIN FOOTER -->
		<%@ include file="personalCenter/personal_center_footer.jsp"%>
		<!-- END FOOTER -->
		<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
		<!-- BEGIN CORE PLUGINS -->
		<!--[if lt IE 9]>
		<script src="../../assets/global/plugins/respond.min.js"></script>
		<script src="../../assets/global/plugins/excanvas.min.js"></script> 
		<![endif]-->
		<script src="../../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
		<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
		<script src="../../assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
		<!-- END CORE PLUGINS -->
		<!-- BEGIN PAGE LEVEL PLUGINS -->
		<script src="../../assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>
		<script src="../../assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
		<!-- END PAGE LEVEL PLUGINS -->
		<!-- BEGIN PAGE LEVEL SCRIPTS -->
		<script src="../../assets/global/scripts/metronic.js" type="text/javascript"></script>
		<script src="../../assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
		<script src="../../assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
		<script src="../../assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
		<script src="../../assets/admin/pages/scripts/profile.js" type="text/javascript"></script>
		<!-- END PAGE LEVEL SCRIPTS -->
		<script>
jQuery(document).ready(function() {       
   // initiate layout and plugins
   Metronic.init(); // init metronic core components
Layout.init(); // init current layout
QuickSidebar.init(); // init quick sidebar
Demo.init(); // init demo features
Profile.init(); // init page demo
});
</script>
<!-- END JAVASCRIPTS -->
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-37564768-1', 'keenthemes.com');
  ga('send', 'pageview');
</script>
</body>
<!-- END BODY -->
</html>

<script>
var nexttID = <%=nexttID%>;
var pretID = <%=pretID%>;
var nextsID = <%=nextsID%>;
var presID = <%=presID%>;
var action = "<%=model%>";
function initPage(){
	
	var id = "<%=id%>";
	$.post("../../userQuery",{action: action,id: id},function(data){
		var html="";
		var json=eval("("+data+")");
		
		if(action == "student"){
			var name = json.sName;
			var id = json.sID;
			var aID = json.aID;
			var email = json.sEmail;
			var major = json.sMajor;
		}else{
			var name = json.tName;
			var id = json.tID;
			var aID = json.aID;
			var email = json.tEmail;
			var major = json.tField;
		}
		
		html=html+"								<div class=\"portlet box green\">";
		html=html+"									<div class=\"portlet-title\">";
		html=html+"										<div class=\"caption\">";
		html=html+"											<i class=\"fa fa-gift\"></i>"+name;
		html=html+"										</div>";
		html=html+"									</div>";
		html=html+"									<div class=\"portlet-body form\">";
		html=html+"										<!-- BEGIN FORM-->";
		html=html+"										<form action=\"../../userChange\" class=\"form-horizontal\">";
		html=html+"											<div class=\"form-body\">";
		html=html+"												<div class=\"form-group\">";
		html=html+"													<label class=\"col-md-3 control-label\">名字：</label>";
		html=html+"													<div class=\"col-md-4\">";
		html=html+"														<input type=\"hidden\" name=\"id\" value="+id+">";
		html=html+"														<input type=\"hidden\" name=\"action\" value="+action+">";
		html=html+"														<input type=\"text\" class=\"form-control input-circle\" name=\"name\" placeholder=\"Enter text\" value="+name+">";
		html=html+"													</div>";
		html=html+"												</div>";
		
		html=html+"												<div class=\"form-group\">";
		html=html+"													<label class=\"col-md-3 control-label\">学院：</label>";
		html=html+"													<div class=\"col-md-4\">";
		html=html+"														<input type=\"text\" class=\"form-control input-circle\" name=\"aID\" placeholder=\"Enter text\" value="+aID+">";
		html=html+"													</div>";
		html=html+"												</div>";
		
		html=html+"												<div class=\"form-group\">";
		html=html+"													<label class=\"col-md-3 control-label\">邮箱：</label>";
		html=html+"													<div class=\"col-md-4\">";
		html=html+"														<input type=\"text\" class=\"form-control input-circle\" name=\"email\" placeholder=\"Enter text\" value="+email+">";
		html=html+"													</div>";
		html=html+"												</div>";
		
		html=html+"												<div class=\"form-group\">";
		html=html+"													<label class=\"col-md-3 control-label\">专业：</label>";
		html=html+"													<div class=\"col-md-4\">";
		html=html+"														<input type=\"text\" class=\"form-control input-circle\" name=\"major\" placeholder=\"Enter text\" value="+major+">";
		html=html+"													</div>";
		html=html+"												</div>";
		
		html=html+"											</div>";
		html=html+"											<div class=\"form-actions\">";
		html=html+"												<div class=\"row\">";
		html=html+"													<div class=\"col-md-offset-5 col-md-9\">";
		html=html+"														<button type=\"submit\" class=\"btn btn-circle blue\">提交修改</button>";
		html=html+"														<button type=\"button\" class=\"btn btn-circle green\" onclick=\"back()\">返回</button>";
		html=html+"														<button type=\"button\" class=\"btn btn-circle default\" onclick=\"pre()\">上一个</button>";
		html=html+"														<button type=\"button\" class=\"btn btn-circle default\" onclick=\"next()\">下一个</button>";
		html=html+"													</div>";
		html=html+"												</div>";
		html=html+"											</div>";
		html=html+"										</form>";
		html=html+"										<!-- END FORM-->";
		html=html+"									</div>";
		html=html+"								</div>";
		
			document.getElementById("class_nav").innerHTML=html;
	});
}

function back(){
	if(action == "teacher")
		window.location="teacherList.jsp";
	else
		window.location = "studentList.jsp";
}
function next(){
	if(action == "teacher"){
		if(nexttID != -1){
			var url = "userInformation.jsp?id="+nexttID;
			window.location = url;
		}else{
			alert("已经到底了！");
		}
	}else{
		if(nextsID != -1){
			var url = "userInformation.jsp?id="+nextsID;
			window.location = url;
		}else{
			alert("已经到底了！");
		}
	}
}
function pre(){
	if(action == "teacher"){
		if(pretID != -1){
			var url = "userInformation.jsp?id="+pretID;
			window.location = url;
		}else{
			alert("已经到头了！");
		}
	}else{
		if(presID != -1){
			var url = "userInformation.jsp?id="+presID;
			window.location = url;
		}else{
			alert("已经到头了！");
		}
	}
}

</script>