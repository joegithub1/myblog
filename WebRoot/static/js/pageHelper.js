//首页
var firstPageJQ=1;
//是否是首页
function firstBoolean(thisNo){
	return thisNo == firstPageJQ;
}
//是否是末页
function lastBoolean(thisNo,lastPage){
	return thisNo == lastPage
}
/*
 * divId:div的id
 * funName:function方法名
 * pi:pageInfo数据
 * 
 */
function paging(divId,funName,pi){
	var pages= pi.pages;
	var pageNum=pi.pageNum;
	var html="";
	if(pages > 0){
		var first = firstBoolean(pageNum);
		if(first){
			//<button type="button" class="btn btn-default">Default</button>
			html+="<button type='button' class='btn btn-default' disabled='disabled' onclick='"+funName+"(1)'    ><<最前页</button>";
			//html+="<a  class='page-btn active'  onclick='"+funName+"(1,true)'    > <<最前页</a>";
		}else{
			html+="<button type='button' class='btn btn-default' onclick='"+funName+"(1)'  ><<最前页</button>";
			//html+="<a  class='page-btn'  onclick='"+funName+"(1,"+first+")'    > <<最前页</a>";
		}
		//html+='<div class="page-list">';
		for(var i =1 ;  i <= pages; i++){
			if(i < pageNum && i > pageNum-5){
				html+="<button class='btn btn-default' onclick='"+funName+"("+i+")' >";
				html+=i;
				html+="</button>";
			}
			if(i == pageNum){
				//当前页点击当前页无效
				html+="<button class='btn btn-primary'  onclick='"+funName+"("+i+")'   >";
				html+=i;
				html+="</button>";
			}
			if(i > pageNum && i < pageNum+5){
				html+="<button class='btn btn-default'  onclick='"+funName+"("+i+")'   >";
				html+=i;
				html+="</button>";
			}	
		}
		//html+="</div>";
		var last = lastBoolean(pageNum,pages);
		if(last){
			html+="<button type='button' class='btn btn-default' disabled='disabled' onclick='"+funName+"("+pages+")'    >  >>最后页</button>";
			//html+="<a class='page-btn active'   onclick='"+funName+"("+pages+",true)'    > >>最后页</a>";
		}else{
			html+="<button type='button' class='btn btn-default'   onclick='"+funName+"("+pages+")'    >      >>最后页</button>";
		 	//html+="<a class='page-btn'   onclick='"+funName+"("+pages+","+last+")'    > >>最后页</a>";
		}
		
	}
	$("#"+divId).html(html);
 
}

function loadRight(url,param){
	param["_time"]=new Date().valueOf();
	$(".index-right").load(url,param);
}

/*填充*/
function loadFormData(fromId,obj){
	
	for(var attr in obj){ 
        
        if(typeof(obj[attr])=='function'){                     
          continue; 
        } 
        var $input = $("#"+fromId+" :input[name='"+attr+"']"); 
        var type = $input.attr("type");     
        if(type=="checkbox" || type=="radio"){ 
        	if(type=="radio"){
            	var avalues = obj[attr];//.split(","); 
                  $input.each(function(i,n){ 
                      var value = $(n).val();  
                      if(value == avalues){     
                        $(n).prop("checked","checked"); 
                      } 
                  }); 
            }
            if(type=="checkbox"){
            	var avalues = obj[attr];//.split(","); 
                //for(var v=0; v<avalues.length;v++){ 
                  $input.each(function(i,n){ 
                      var value = $(n).val();  
                      console.log(value+"-------"+avalues[v]);
                      if(value == avalues[v]){                        
                        $(n).prop("checked","checked"); 
                      } 
                  }); 
             // } 
            }
            
        }else{ 
          $input.val(obj[attr]); 
        } 
          
      }
	
}






