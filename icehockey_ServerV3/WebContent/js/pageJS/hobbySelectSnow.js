/**
 * Created by Administrator on 2017/7/16.
 */
$(function(){

    var hobbyType = comm.getUrlParameter("play");
    var sportEvent = null;

    $("#danban").click(function(){
        //每个按钮执行的操作
        sportEvent = "DB";//单板
        submit(sportEvent);
    });

    $("#shuangban").click(function(){
        sportEvent = "SB";//双板
        submit(sportEvent);
    });

    $("#all").click(function(){
        sportEvent = "DS";//单双都玩
        submit(sportEvent);
    });
    
 // 此函数是为了获取url上携带的参数
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}
	
    //提交用户选择的信息
    function submit(sportEvent){
        var r=confirm("确认要提交吗？");
        if (r==true)
        {
            var data = {
            	play : hobbyType,
                snow_play : sportEvent,
                userid : GetQueryString('userid')
            };

            alert(JSON.stringify(data));
            //TODO 请求后台保存数据
            $.getJSON(SNOWURL,data,function(result){
                //TODO 处理后台返回的结果
            	var jsonReturn = JSON.parse(result);
				if (jsonReturn.result == "0") {
					alert(result);
                    //提交成功之后进行的操作
                    //window.location.href = "../roleChoose/role.html";
                }else{
                	alert("后台数据处理有误");
                }
            });
        }
        else
        {

        }



    }

});