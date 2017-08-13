// JavaScript Document
var isIe=(document.all)?true:false;
//鐠佸墽鐤唖elect閻ㄥ嫬褰茬憴浣哄Ц閹拷
function setSelectState(state)
{
var objl=document.getElementsByTagName('select');
for(var i=0;i<objl.length;i++)
{
objl[i].style.visibility=state;
}
}
function mousePosition(ev)
{
if(ev.pageX || ev.pageY)
{
return {x:ev.pageX, y:ev.pageY};
}
return {
x:ev.clientX + document.body.scrollLeft - document.body.clientLeft,y:ev.clientY + document.body.scrollTop - document.body.clientTop
};
}
//瀵懓鍤弬瑙勭《
function showMessageBox(wTitle,content,pos,wWidth,wHeight)
{
closeWindow();
var bWidth=parseInt(document.documentElement.scrollWidth);
var bHeight=parseInt(document.documentElement.scrollHeight);
if(isIe){
setSelectState('hidden');}
var back=document.createElement("div");
back.id="back";
var styleStr="top:0px;left:0px;position:absolute;background:#666;width:"+bWidth+"px;height:"+bHeight+"px;";
styleStr+=(isIe)?"filter:alpha(opacity=40);":"opacity:0.40;";
back.style.cssText=styleStr;
document.body.appendChild(back);
var mesW=document.createElement("div");
mesW.id="mesWindow";
mesW.className="mesWindow";
mesW.innerHTML="<div class='mesWindowTop'><table width='100%' height='100%'><tr><td>"+wTitle+"</td><td style='width:3px;'><input type='button' onclick='closeWindow();' title='閸忔娊妫寸粣妤�經' class='close' value='X' /></td></tr></table></div><div class='mesWindowContent' id='mesWindowContent'>"+content+"</div><div class='mesWindowBottom'></div>";
styleStr="width:"+wWidth+"px;height:"+wHeight+"px;position:absolute;top:50%;left:50%;margin-left:-"+wWidth/2+"px;margin-top:-"+wHeight/2+"px;";
mesW.style.cssText=styleStr;
document.body.appendChild(mesW);
}
function showBackground(obj,endInt)
{
obj.filters.alpha.opacity+=1;
if(obj.filters.alpha.opacity<endInt)
{
setTimeout(function(){showBackground(obj,endInt)},8);
}
}
//閸忔娊妫寸粣妤�經
function closeWindow()
{
if(document.getElementById('back')!=null)
{
document.getElementById('back').parentNode.removeChild(document.getElementById('back'));
}
if(document.getElementById('mesWindow')!=null)
{
document.getElementById('mesWindow').parentNode.removeChild(document.getElementById('mesWindow'));
}
if(isIe){
setSelectState('');}
}
//濞村鐦鐟板毉
function testMessageBox(ev)
{
var objPos = mousePosition(ev);
messContent="<div style='padding:20px 0 20px 0;text-align:center'>"+"<div align='center'><form name='f1' method='post' action='test1.html'><table><tr><td align='right'><p>username</p></td><td align='left'><input type='text' name='t1'> </td></tr><tr><td align='right'>password<td align='left'><input type='password' name='t2'></td></tr><tr> <td align='right'><input type='submit' value='submit' onclick='isValid()' /></td><td align='left'><input type='reset' value='reset'> </td></tr></table></form></div>"+"</div>";
showMessageBox('Login',messContent,objPos,400,200);
}

function isValid()
{
	if(f1.t1.value=="")
	{
     alert("Please enter username");
    }
	if(f1.t2.value=="")
	{
     alert("Please enter password");
    }
}