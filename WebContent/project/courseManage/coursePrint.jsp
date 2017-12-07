<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.text.*,org.json.JSONObject,org.json.JSONArray,java.util.List"%>
<%
	//做调试用，这里要在正式发布的时候去掉
	System.out.println("["+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new java.util.Date())+"]=======================调试："+request.getServletPath()+"开始==============================");
%>
<%
	JSONObject jsonObj = null;
	if(session.getAttribute("courseData")!=null){
		//System.out.println("session not empty!" + session.getAttribute("courseData"));
		jsonObj= new JSONObject((String)session.getAttribute("courseData"));
		//System.out.println("get courseData!" + jsonObj);
	}
	JSONArray courseList=jsonObj.getJSONArray("courseList");
	int totalCount=courseList.length();
	System.out.println(totalCount);
	
%>
<html>
<body>
<div>
	<input type="button" class="no_print" value="打印" onclick="javascript:window.print()">
	<input type="button" class="no_print" value="返回" onclick="back()">
	<input type="button" style="display:none;" value="页面设置" onclick="javascript:WebBrowser.ExecWB(8,1)">
	<input type="button" style="display:none;" value="打印预览" onclick="javascript:WebBrowser.ExecWB(7,1)">
<div>
<div align=center>

<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 style='border-collapse: collapse; border: none; mso-border-alt: solid black .5pt; mso-yfti-tbllook: 1184; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt; mso-border-insideh: .5pt solid black; mso-border-insidev: .5pt solid black'>
					<tr style='mso-yfti-irow: 0; mso-yfti-firstrow: yes'>
						<td width=568 colspan=5 valign=top style='width: 426.1pt; border: none; border-bottom: solid black 1.0pt; mso-border-bottom-alt: solid black .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal>
								<span style='font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>课表</span><span lang=EN-US><o:p></o:p>
								</span>
							</p>
						</td>
					</tr>
					<tr style='mso-yfti-irow: 1'>
						<td width=54 valign=top style='width: 40.85pt; border: solid black 1.0pt; border-top: none; mso-border-top-alt: solid black .5pt; mso-border-alt: solid black .5pt; background: #BFBFBF; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>序号</span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; background: #BFBFBF; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>课程名</span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'></span><span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'></span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; background: #BFBFBF; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>授课老师</span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'></span><span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'></span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p></o:p>
								</span>
							</p>
						</td>
					</tr>
<%
		for(int i=0;i<totalCount;i++) {
		JSONObject courseInfo = courseList.getJSONObject(i);
		//System.out.println("courseInfo: " + courseInfo);
		int cID = courseInfo.getInt("cID");
		String cName = courseInfo.getString("cName");
		String tName = courseInfo.getString("tName");
%>
	<tr style='mso-yfti-irow: 2'>
						<td width=54 valign=top style='width: 40.85pt; border: solid black 1.0pt; border-top: none; mso-border-top-alt: solid black .5pt; mso-border-alt: solid black .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal>
								<span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p><%=cID %></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal>
								<span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p><%=cName %></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal>
								<span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p><%=tName %></o:p>
								</span>
							</p>
						</td>
						
					</tr>
					<%
	}
	System.out.println("显示完了！");
%>
</table>
</div>
</body>
</html>
<script>
function back(){
	window.location="courseList.jsp";
}
</script>
