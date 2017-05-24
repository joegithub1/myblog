$.fn.extend({
	check:function(){
		return this.each(function(){
			this.checked = true;
		});
	},
	
	uncheck:function(){
		return this.each(function(){
			this.checked = false;
		});
	},
	ischeck:function(all_id){
		var all_check = document.getElementById(all_id).checked;
		return this.each(function(){
			this.checked = all_check;
		});
	},
	smallchange:function(all_id){
		//总长度
		var count = $(this).length;
		var checkNum=0;//选中的个数
		this.each(function(){
			if(this.checked){
				checkNum ++;
			}else{
				
			}
		});
		document.getElementById(all_id).checked=checkNum == count ;	
	},
	checkvalue:function(){
		var arr=new Array();
		this.each(function(index,element){
			if(this.checked){
				arr.push(this.value);
			}
		});
		return arr;
	}
});