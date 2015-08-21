<%
if(session.getAttribute("usuario")==null || session.getAttribute("usuario")=="")
{
%>
<meta http-equiv="refresh" content="0; url=../index.html" />
<%
}
%>