/**
 * Created by Administrator on 2017/7/16.
 */
$(function(){

    var hobbyType = comm.getUrlParameter("hobbyType");
    var sportEvent = null;

    $("#danban").click(function(){
        //每个按钮执行的操作
        sportEvent = "DB";
        submit(sportEvent)
    });

    $("#shuangban").click(function(){
        sportEvent = "SB";
        submit(sportEvent)
    });

    $("#all").click(function(){
        sportEvent = "DS";
        submit(sportEvent)
    });
    //提交用户选择的信息
    function submit(sportEvent){
        var r=confirm("确认要提交么");
        if (r==true)
        {
            var data = {
                snow_play : sportEvent
            };

            alert(JSON.stringify(data));
            //TODO 请求后台保存数据
            $.getJSON(SNOWURL,data,function(result){
                //TODO 处理后台返回的结果
                if(result.result!==null){
                    //提交成功之后进行的操作

                    window.location.href = "../roleChoose/role.html";
                }
            });
        }
        else
        {

        }



    }

});