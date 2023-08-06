loadSavingLevels();
let $bigdiv = $("#forcontent");
let $btns = $(".SchoolLectureBarButton_lectureBarLi__2shyU");

function loadSavingLevels() {
  let text = "";
  let i =0;
    $(".SchoolLectureListDesktop_mainSchoolLecture__3f2nw").html("");
  savinglevels.forEach(savinglevel=>{
                        text += `
                            <div class="SchoolLectureListDesktop_schoolLecture__2EK3P">
                        <span class="SchoolLectureListDesktop_background__2Kqf_ SchoolLectureListDesktop_visible__2lI79">
                            <img src="/files/display?fileName=${savinglevel.filePath}/t_${savinglevel.uuid}_${savinglevel.originName}" class="preview" style="width: 170px" alt="이게안나오">
  
                            </span>
                        <a href="">
                            <div class="SchoolLectureListDesktop_lectureCon__BhKMl">
                                <p class="SchoolLectureListDesktop_lectureType__8_hUF">
                                            <span>
                                                <i class="SchoolLectureListDesktop_reward__A5Tp${savinglevel.savinglevelId}"></i>
                                                ${savinglevel.savinglevelName}
                                            </span>
                                <p class="SchoolLectureListDesktop_lectureTitle__2wTDN">
                                ${savinglevel.content}
                                </p>
                                <p class="SchoolLectureListDesktop_lectureSub__3soFP">
                                   목표금액 : ${savinglevel.goalMoney} 원
                                </p>
                                <p class="SchoolLectureListDesktop_lectureInfo__1dFY_">
                                    일일금액 : ${savinglevel.dailyMoney} 원
                                </p>
                                 <p class="SchoolLectureListDesktop_lectureNum__oypsR">
                                    <em>자세히보러가기</em>
                                   <img src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-arrow-right-c-1024.png" style="height:10px;" alt="">
                                </p>
                                </p>
                                </p>
                            </div>
                        </a>
                    </div>`
      i++;
    });
    $(".SchoolLectureListDesktop_mainSchoolLecture__3f2nw").html(text);
};
$(function(){
    $btns.each(function(i, btn) {
        $(btn).on('click', function (e) {
            e.preventDefault();
        });
    });
});

function loaditems(items) {
    let text = "";
    let i = 0;
    $(".SchoolLectureListDesktop_mainSchoolLecture__3f2nw").html("");
    items.forEach(item =>
        {
        text += `<div class="SchoolLectureListDesktop_schoolLecture__2EK3P">
                        <span class="SchoolLectureListDesktop_background__2Kqf_ SchoolLectureListDesktop_visible__2lI79">
                            <img src="/files/display?fileName=${item.filePath}/t_${item.fileUuid}_${item.fileOriginName}" class="preview" style="width: 170px" alt="${item.fileOriginName}">
                            </span>
                        <a href="/join/gotosavingdetails?id=${item.itemId}">
                            <div class="SchoolLectureListDesktop_lectureCon__BhKMl">
                                <p class="SchoolLectureListDesktop_lectureType__8_hUF">
                                            <span>
                                                <i class="SchoolLectureListDesktop_reward__A5Tp${item.savingLevelId}"></i>
                                                ${item.savingLevelName}
                                            </span>
                                <p class="SchoolLectureListDesktop_lectureTitle__2wTDN">
                                ${item.itemName}
                                </p>
                                <p class="SchoolLectureListDesktop_lectureSub__3soFP">
                                   가격 : ${item.price} 원
                                </p>
                                <p class="SchoolLectureListDesktop_lectureInfo__1dFY_">
                                    수량 : ${item.currentStock}개 / ${item.originStock}개
                                </p>
                                 <p class="SchoolLectureListDesktop_lectureNum__oypsR">
                                    <em>자세히보러가기</em>
                                   <img src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-arrow-right-c-1024.png" style="height:10px;" alt="">
                                </p>
                                </p>
                                
                                </p>
                            </div>
                        </a>
                    </div>`
        i++;
    });
    $(".SchoolLectureListDesktop_mainSchoolLecture__3f2nw").html(text);
}

$btns.eq(0).on('click',function(){
    $.ajax({
        type:"GET",
        url :"mainpage",
        success:function (result) {
            loadSavingLevels(result)
        }
    });
});

$btns.eq(1).on('click',function(){
    $.ajax({
        type : "GET",
        url : "getItemAll",
        success : function(result){
            loaditems(result)
            console.log(result);
        }
    });
});

$btns.eq(2).on('click',function(){
    $.ajax({
        type : "GET",
        url : "getItem",
        data: {savingLevelId: 1},
        success : function(result){
            loaditems(result)
            console.log(result);
        }
    });

});

$btns.eq(3).on('click',function(){
    $.ajax({
        type : "GET",
        url : "getItem",
        data: {savingLevelId: 2},
        success : function(result){
            loaditems(result)
            console.log(result);
        }
    });
});

$btns.eq(4).on('click',function(){
    $.ajax({
        type : "GET",
        url : "getItem",
        data: {savingLevelId: 3},
        success : function(result){
            loaditems(result)
            console.log(result);
        }
    });
});