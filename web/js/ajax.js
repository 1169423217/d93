$(function () {
    //获得id为name的控件。绑定键盘弹起事件
    $("#name").keyup(function () {
        //获得这个控件的值
        var val=$(this).val();

        //判断这个值是否为空
        if (val==""){
            //文本框没有数据，清楚div中的全部内容
            $("#mydiv").html("")

        }else {

        //     $.ajax({
        //         url:"请求路径",
        //         type:"请求方式是get还是post",
        //         data:json格式的参数,
        //         dataType:"后台还回的数据类型", @@@@@@@@@@如果不声明该属性，默认返回类型是String
        //     success:成功的回调函数,
        //         error:出错后的回调函数
        // });

            //进入servlet路径为ajax 给
                $.post("ajax",
                    //name的控件传递参数
                    {"name":val},
                    //回调函数
                    function (data) {
                    $("#mydiv").html(data);

                    $("#mydiv>div").mousemove(function () {
                        $(this).css("background","lime");
                    }).mouseout(function () {
                        $(this).css("background","white");
                    }).click(function () {
                        //把当前div的内容赋值给文本框
                        var val=$(this).html();
                        $("#name").val(val);
                        //将mydiv显示的内容，进行清除
                        $("#name").html("");


                    })
                    
                })

        }
        
    })

});

