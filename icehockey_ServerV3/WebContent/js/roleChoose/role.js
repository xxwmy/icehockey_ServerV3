/**
 * Created by Administrator on 2017/7/17.
 */
$(function(){

    var sportEvent = null;

    $("#qiuyuan").click(function(){
        //每个按钮执行的操作
        sportEvent = "QY";//球员
        submit(sportEvent)
    });

    $("#jiaolian").click(function(){
        sportEvent = "JL";//教练
        submit(sportEvent)
    });

    $("#shoumen").click(function(){
        sportEvent = "SM";//守门
        submit(sportEvent)
    });
    $("#caipan").click(function(){
        sportEvent = "CP";//裁判
        submit(sportEvent)
    });
    $("#school").click(function(){
    	window.location.href = "school.html";//校队
       // sportEvent = "DS";
       // submit(sportEvent)
    });
    $("#xiehui").click(function(){
       // sportEvent = "DS";//协会
       // submit(sportEvent)
       window.location.href = "team.html";
    });


    //提交用户选择的信息
    var urlUserId=comm.getUrlParameter("userid");
    function submit(sportEvent){
        var r=confirm("确认要提交么");
        if (r==true)
        {
            var data = {
                role : sportEvent,
                userid:urlUserId
            };

            alert(JSON.stringify(data));
            //TODO 请求后台保存数据
            $.getJSON(ROLEURL,data,function(result){
            	var jsonReturn = JSON.parse(result);
                //TODO 处理后台返回的结果
                if(jsonReturn.result == "0"){
                    //提交成功之后进行的操作
                    window.location.href = 'chiganfangshi.html?userid='+jsonReturn.userid;
                }
            });
        }
        else
        {

        }



    }
});