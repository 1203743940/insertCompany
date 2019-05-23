
( function check() {
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
    });
