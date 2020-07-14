<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 5px;
	margin-top: 5px;
	margin-right: 5px;
	margin-bottom: 5px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<script type="text/javascript">
   function tijiao(){
	 
	   
	   document.myform.submit();
	   
   }
</script>

</head>

<body>
 <form action="../../ShopUpdate" method="post" enctype="multipart/form-data" name="myform">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="d5d4d4" >
  <tr>
    <td height="22" colspan="4" background="images/bg.gif" bgcolor="#FFFFFF" class="STYLE3"><div align="center">商品编辑</div></td>
  </tr>
  <tr>
    <td colspan="4" bgcolor="#FFFFFF" class="STYLE1"><table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="142" height="35" class="STYLE1" nowrap="nowrap"><div align="left">商品名称</div></td>
        <td width="352" height="35" class="STYLE1"><div align="left">
          <input type="text" name="itemName"   style="width:200px; height:17px; font-size:12px; border:solid 1px #ccc; "  value="${param.itemName }" />
        </div></td>
        <td width="173" height="35" class="STYLE1"nowrap="nowrap"><div align="left">种类编号</div></td>
        <td width="188" height="35" class="STYLE1"><div align="left">
          <input type="text" name="cid"   style="width:200px; height:17px; font-size:12px; border:solid 1px #ccc; " value="${param.cid }" />
        </div></td>
      </tr>
      <tr>
        <td width="142" height="35" class="STYLE1" nowrap="nowrap"><div align="left">制造商</div></td>
        <td height="35" colspan="3" class="STYLE1"><div align="left">
          <input type="text" name="itemProductor"   style="width:300px; height:17px; font-size:12px; border:solid 1px #ccc; " value="${param.itemProductor }" />
        </div></td>
        </tr>
      <tr>
        <td width="142" height="35" class="STYLE1" nowrap="nowrap"><div align="left">商品图片</div></td>
        <td height="35" colspan="3" class="STYLE1"><div align="left">
          <input type="file" name="upload"   style="width:300px; height:17px; font-size:12px; border:solid 1px #ccc; " />
        </div></td>
        </tr>
      <tr>
        <td width="142" height="35" class="STYLE1"><div align="center" nowrap="nowrap">
          <div align="left">会员价格</div>
        </div></td>
        <td height="35" class="STYLE1"><div align="left">
          <input type="text" name="priceVip"   style="width:200px; height:17px; font-size:12px; border:solid 1px #ccc; " value="${param.priceVip }"/>
        </div></td>
        <td height="35" class="STYLE1"><div align="center" nowrap="nowrap">
          <div align="left">普通价格</div>
        </div></td>
        <td height="35" class="STYLE1"><div align="left">
          <input type="text" name="priceNormal"   style="width:200px; height:17px; font-size:12px; border:solid 1px #ccc; " value="${param.priceNormal }"/>
        </div></td>
      </tr>
      <tr>
        <td width="142" height="35" class="STYLE1"><div align="center" nowrap="nowrap">
          <div align="left">库存数量</div>
        </div></td>
        <td height="35" class="STYLE1"><div align="left">
          <input type="text" name="itemNum"   style="width:200px; height:17px; font-size:12px; border:solid 1px #ccc; " value="${param.itemNum }"/>
        </div></td>
        <td height="35" class="STYLE1"><div align="center" nowrap="nowrap">
          <div align="left">商品状态</div>
        </div></td>
        <td height="35" class="STYLE1"><div align="left">
          <select name="itemState"  style="width:200px; height:17px; font-size:12px;">
            <option value="0">上架</option>
            <option value="1">下架</option>
          </select>
        </div></td>
      </tr>
      <tr>
        <td width="142" height="35" class="STYLE1"><div align="center" nowrap="nowrap">
          <div align="left">商品介绍</div>
        </div></td>
        <td height="35" colspan="3" class="STYLE1"><div align="left">
          <textarea name="itemIntro"  style=" width:600px; height:100px;">${param.itemIntro }</textarea>
        </div></td>
        </tr>
      <tr>
      <!-- 其他数据就使用隐藏域 -->
            <input type="hidden" name="itemTotNum" value="${param.itemTotNum }">
            <input type="hidden" name="itemPhoto" value="${param.itemPhoto }">
            <input type="hidden" name="itemId" value="${param.itemId }">
        <td height="40" class="STYLE1">&nbsp;</td>
        <td height="35" colspan="3" class="STYLE1"><img src="images/syb.gif" width="62" height="21" onclick="history.back()"/><img src="images/xyb.gif" width="62" height="21" onclick="tijiao()"/></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
