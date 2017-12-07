<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.text.*,org.json.JSONObject,org.json.JSONArray,java.util.List"%>
<%
	//做调试用，这里要在正式发布的时候去掉
	System.out.println("["+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new java.util.Date())+"]=======================调试："+request.getServletPath()+"开始==============================");
%>
<%
	String model = (String)session.getAttribute("model");
	JSONObject userData=null;
	if(session.getAttribute("userData")!=null){
	System.out.println("come in!");
		userData = new JSONObject((String)session.getAttribute("userData"));
		System.out.println(userData);
	}
	
	
	JSONArray arr = userData.getJSONArray(model+"List");
	System.out.println(userData);
	int totalCount=arr.length();
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
								<span style='font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>用户表</span><span lang=EN-US><o:p></o:p>
								</span>
							</p>
						</td>
					</tr>
					<tr style='mso-yfti-irow: 1'>
						<td width=54 valign=top style='width: 40.85pt; border: solid black 1.0pt; border-top: none; mso-border-top-alt: solid black .5pt; mso-border-alt: solid black .5pt; background: #BFBFBF; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>ID</span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; background: #BFBFBF; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>名字</span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'></span><span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'></span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; background: #BFBFBF; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal align=center style='text-align: center'>
								<span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'>学院</span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'></span><span style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt; font-family: 宋体; mso-ascii-font-family: Calibri; mso-hansi-font-family: Calibri'></span><span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p></o:p>
								</span>
							</p>
						</td>
						
					</tr>
<%
		for(int i=0;i<totalCount;i++) {
		int id,aID;
		String name;
		if(model.equals("teacher")){
			JSONObject teacher = arr.getJSONObject(i);
			id = teacher.getInt("tID");
			aID = teacher.getInt("aID");
			name = teacher.getString("tName");
		}else{
			JSONObject student = arr.getJSONObject(i);
			id = student.getInt("sID");
			aID = student.getInt("aID");
			name = student.getString("sName");
		}
		
%>
	<tr style='mso-yfti-irow: 2'>
						<td width=54 valign=top style='width: 40.85pt; border: solid black 1.0pt; border-top: none; mso-border-top-alt: solid black .5pt; mso-border-alt: solid black .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal>
								<span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p><%=id %></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal>
								<span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p><%=name %></o:p>
								</span>
							</p>
						</td>
						<td width=132 valign=top style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid black 1.0pt; border-right: solid black 1.0pt; mso-border-top-alt: solid black .5pt; mso-border-left-alt: solid black .5pt; mso-border-alt: solid black .5pt; padding: 0cm 5.4pt 0cm 5.4pt'>
							<p class=MsoNormal>
								<span lang=EN-US style='font-size: 14.0pt; mso-bidi-font-size: 11.0pt'><o:p><%=aID %></o:p>
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
var model="<%=model%>";
		window.location=model+"List.jsp";
}
</script>
