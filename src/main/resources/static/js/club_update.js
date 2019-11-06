function checkMemberNumber(obj) {
    var memberNumber = $(obj).val();
    var re =  /^(0|\+?[1-9][0-9]*)$/;
    if(!re.test(memberNumber)){
        alert("会员数必须是正整数！");
        $(obj).val("");
        $(obj).focus();
    }
}

function checkClubName(obj) {
    var clubName = $(obj).val();
    var clubId = $("input[name='clubId']").val();
    var Data = {"clubName":clubName,"clubId":clubId};
    $.ajax({
        type: "Post",
        url: "/checkNameOfUpdate",
        data: JSON.stringify(Data),
        dataType: "text",
        contentType: "application/json;charset=UTF-8",
        success: function(result){
            if("false"==result){
                alert("俱乐部的名称已经存在了，请重新取名！");
                $(obj).val("");
                $(obj).focus();
            }
        },
        error:function (result) {
            alert("失败");
            alert(result);
        }
    })
}