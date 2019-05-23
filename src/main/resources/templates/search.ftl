<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">

    <meta charset="UTF-8">
    <title>外拖公司绑卡入闸资料录入</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3  class="text-center text-info">
                外拖公司绑卡入闸资料录入
            </h3>
            <h4 class="text-warning">
                录入须知
            </h4>

            <ol>
                <li>
                    请先在eportal上开通该公司eportal外部账号，并给予外拖绑卡权限。如不知新建账号，请<a href="/getLastAccount">点击这里</a> 。
                </li>
                <li>
                    公司名称和公司eportal账号为必输入选项。
                </li>
                <li>
                    若显示结果为公司无备案，请联系业务部许介加8922，并回复邮件该公司无备案。
                </li>


            </ol>
            <form role="form" action="/insertCom" onsubmit="return check()">
                <div class="form-group">
                    <label>公司名称</label><input type="text" class="form-control" id="companyName" name = "companyName" />
                </div>
                <div class="form-group">
                    <label>公司联系人</label><input type="text" class="form-control" id="contactPerson"  name = "contactPerson"/>
                </div>
                <div class="form-group">
                    <label>联系方式</label><input type="text" class="form-control" id="phone"  name = "phone"/>
                </div>
                <div class="form-group">
                    <label>公司eportal账号</label><input type="text" class="form-control" id="account" name = "account" />
                </div>

                <div class="checkbox">

                </div> <button type="submit" class="btn btn-default">Submit</button>



            <#-- <a id="modal-782068" href="#modal-container-782068" role="button" class="btn" data-toggle="modal">Submit</a>

             <div class="modal fade" id="modal-container-782068" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                 <div class="modal-dialog">
                     <div class="modal-content">
                         <div class="modal-header">
                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                             <h4 class="modal-title" id="myModalLabel">
                                 确认提交？
                             </h4>
                         </div>
                         <div class="modal-body">
                             <p id="getContent"></p>
                         </div>
                         <div class="modal-footer">
                             <button type="button" class="btn btn-default" data-dismiss="modal">取消</button> <button type="submit" class="btn btn-primary">提交</button>
                         </div>
                     </div>

                 </div>

             </div>-->
            </form>

        </div>

    </div>
</div>
<div></br></div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">


                <h4>
                    注意!
                </h4> <strong>${tips}</strong>
            </div>
        </div>
    </div>
</div>



</body>
<#--<script src="static/jquery.js"></script>
<script type="text/javascript">

    $(document).ready(function(){
        var companyName = $(".companyName").value;
        var phone = $("#phone").value;
        var account = $("#account").value;
        var contactPerson = $("#contactPerson").value;
        $("p.getContent").text(companyName);

    });
</script>-->

<script type="text/javascript">

    function check() {
        var gnl = confirm("确定要提交?");
        if (gnl == true) {
            var companyName = document.getElementById("companyName").value;
            var account = document.getElementById("account").value;
            if (companyName == null || account == null || companyName == "" || account == ""){
                alert("公司名和账户不能为空");
                return false;}
            else{
                return true;
            }
        }
        else {
            return false;
        }
    }
</script>
</html>