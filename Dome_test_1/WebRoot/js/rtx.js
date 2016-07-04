$(function(){ 
  String.prototype.NoSpace = function() 
  { 
    return this.replace(/\s+/g, "");
  }
  var rtxName1 = rtx.NoSpace().toLowerCase();
  var rtxName2 = rtxName1.replace(/(\w)/,function(v){return v.toUpperCase()});
  var src = "http://dayu.oa.com/avatars/"+rtxName1+"/profile.jpg";
  $('li.user-menu').find('img.user-image').attr("src",src);
  $('li.user-header').find('img.img-circle').attr("src",src);
  $('div.user-panel').find('img.img-circle').attr("src",src);
  $('span.hidden-xs').text(rtxName2);
  $('li.user-header').find('p').text(rtxName2);
  $('div.user-panel').find('p').text(rtxName2);
});