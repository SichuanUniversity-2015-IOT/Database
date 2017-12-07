<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% int courseCount = Integer.parseInt((String)session.getAttribute("courseCount")); %>
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
		<script src="js/echarts.js"></script>
	</head>
	<!-- END HEAD -->
	<!-- BEGIN BODY -->
	<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed page-sidebar-closed-hide-logo page-container-bg-solid" onload="initPage()">
		
		<div class="clearfix">
		</div>
		<!-- BEGIN CONTAINER -->
		<div class="page-container">
			
			
		<div class="page-content">
			<%@ include file="personalCenter/personal_center_page_header.jsp"%>
			
			<!-- BEGIN PAGE CONTENT-->
			<div class="row margin-top-20">
				<div class="col-md-12">
				<div class="row">
						<%@include file="sideBar.jsp" %>
						
							
						<div class="col-md-8 col-sm-8">
							<div class="portlet light profile-sidebar-portlet">
								<div id="main" style="width: 600px;height:400px;" ></div>
								<div class="col-md-offset-5 col-md-9">
									<button type="button" class="btn btn-circle red" onclick="back()">返回</button>
								</div>
							</div>
						
				</div>
				
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var courseCount = <%=courseCount %>;
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '柱状图'
            },
            tooltip: {},
            legend: {
                data:['个数']
            },
            xAxis: {
                data: ["课程总数"]
            },
            yAxis: {},
            series: [{
                name: '个数',
                type: 'bar',
                data: [courseCount]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        function back(){
        	window.location="courseList.jsp";
        }
    </script>
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
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
function initPage(){
	var txt = "teacher";
	$.post("../../class_query_action",{user_id: txt},function(data){
		var html="";
		var json=eval("("+data+")");
		var list=json.aaData;
		html=html+list.length;
		document.getElementById("class_num").innerHTML=html;
	});
}
</script>