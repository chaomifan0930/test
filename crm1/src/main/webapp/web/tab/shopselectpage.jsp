<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <head>
    <title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.STYLE7 {font-size: 12}

-->
</style>

<script>
var  highlightcolor='#eafcd5';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="web/tab/images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="web/tab/images/tab_05.gif"><img src="web/tab/images/311.gif" width="16" height="16" /> <span class="STYLE4">商品列表</span></td>
        <td width="281" background="web/tab/images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                        <input type="checkbox" name="checkbox62" value="checkbox" />
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="web/tab/images/001.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">
                    <a href="web/tab/shopadd.jsp">新增</a>
                    </div></td>
                  </tr>
              </table></td>
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="web/tab/images/083.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="web/tab/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="web/tab/images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="6%" height="26" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="8%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">商品编号</div></td>
            <td width="8%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">商品名称</div></td>
            <td width="8%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">种类编号</div></td>
            <td width="10%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">制造商</div></td>
            <td width="10%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">商品图片</div></td>
            <td width="8%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">会员价格</div></td>
            <td width="8%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">普通价格</div></td>
            <td width="8%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">库存数量</div></td>
            <td width="10%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">商品状态</div></td>
            <td width="7%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">编辑</div></td>
            <td width="7%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">删除</div></td>
          </tr>
          
          <c:forEach items="${requestScope.item }" var="it">
          <tr>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <input name="checkbox" type="checkbox" class="STYLE2" value="checkbox" />
            </div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${it.itemId}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${it.itemName}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${it.cid}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${it.itemProductor}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
                <a  href="ShopDownload?name=upload/${it.itemPhoto}">        
                     <img src="upload/${it.itemPhoto}" width="88px" height="88px">
              </a></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${it.priceVip}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${it.priceNormal}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${it.itemNum}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${it.itemState}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="web/tab/images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="web/tab/shopupdate.jsp?itemId=${it.itemId}&itemName=${it.itemName}&cid=${it.cid}&itemProductor=${it.itemProductor}&itemPhoto=${it.itemPhoto}&itemIntro=${it.itemIntro}&priceVip=${it.priceVip}&priceNormal=${it.priceNormal}&itemNum=${it.itemNum}&itemTotNum=${it.itemTotNum}&itemState=${it.itemState}">编辑</a><span class="STYLE1">]</span></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2"><img src="web/tab/images/010.gif" width="9" height="9" /> </span><span class="STYLE1">[</span><a href="ShopDelete?itemId=${it.itemId}" onclick="return window.confirm('是否确定删除？')">删除</a><span class="STYLE1">]</span></div></td>
          </tr>
          </c:forEach> 
          
        </table></td>
        <td width="9" background="web/tab/images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="web/tab/images/tab_20.gif" width="15" height="29" /></td>
        <td background="web/tab/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"><span class="STYLE1">共${p.pageTotal }条纪录，当前第${p.pageNum }/${p.pageSum }页，每页${p.pageSize }条纪录</span></td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle">
                  <div align="right">
                    <a href="ShopListPage?pageNum=1"><img src="web/tab/images/first.gif" width="37" height="15" /></a>
                  </div>
                  </td>
                  <td width="50" height="22" valign="middle">
                  <div align="right">
                     <a href="ShopListPage?pageNum=${p.pageNum>1 ? (p.pageNum-1):1  }"><img src="web/tab/images/back.gif" width="43" height="15" /></a>
                  </div>
                  </td>
                  <td width="54" height="22" valign="middle">
                  <div align="right">
                     <a href="ShopListPage?pageNum=${p.pageNum<p.pageSum ? (p.pageNum+1):p.pageSum  }"><img src="web/tab/images/next.gif" width="43" height="15" /></a>
                  </div>
                  </td>
                  <td width="49" height="22" valign="middle">
                  <div align="right">
                    <a href="ShopListPage?pageNum=${p.pageSum  }"><img src="web/tab/images/last.gif" width="37" height="15" /></a>
                  </div>
                  </td>
                  <!-- <td width="59" height="22" valign="middle"><div align="right">转到第</div></td>
                  <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="textfield" type="text" class="STYLE1" style="height:10px; width:25px;" size="5" />
                  </span></td>
                  <td width="23" height="22" valign="middle">页</td> 
                  <td width="30" height="22" valign="middle"><img src="web/tab/images/go.gif" width="37" height="15" /></td>-->
                </tr>
              </table>
            </div></td>
          </tr>
        </table></td>
        <td width="14"><img src="web/tab/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
