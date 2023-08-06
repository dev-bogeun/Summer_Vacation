
const Calendar = tui.Calendar;
const container = document.getElementById('calendar');
const options = {
    defaultView: 'month',
    useFormPopup: true,
    useDetailPopup: true,
    isReadOnly: true,

    gridSelection: {
        enableDblClick: false,
        enableClick: false,
    },
    month: {
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        isAlways6Weeks: false,
        visibleEventCount: 4,
    },
    timezone: {
        zones: [
            {
                timezoneName: 'Asia/Seoul',
                displayLabel: 'Seoul',
            },
            {
                timezoneName: 'Europe/London',
                displayLabel: 'London',
            },
        ],
    },


    // calendars: [
    //     {
    //         id: '1',
    //         name: '과학',
    //         backgroundColor: '#2e51ef',
    //     },
    //     {
    //         id: '2',
    //         name: '스포츠',
    //         backgroundColor: '#9f8673',
    //     },
    //
    //     {
    //         id: '3',
    //         name: '전통',
    //         backgroundColor: '#705f53',
    //     },
    //
    //     {
    //         id: '4',
    //         name: '박물관',
    //         backgroundColor: '#74aaf0',
    //     },
    //     {
    //         id: '5',
    //         name: '농촌',
    //         backgroundColor: '#90949c',
    //     },
    //     {
    //         id: '6',
    //         name: '미술관',
    //         backgroundColor: '#9b72e7',
    //     },
    //     {
    //         id: '7',
    //         name: '공방',
    //         backgroundColor: '#f0bb9d',
    //     },
    //     {
    //         id: '8',
    //         name: '기타',
    //         backgroundColor: '#7a87f5',
    //     }
    // ],
};


const calendar = new Calendar(container, options);

var currentDate = calendar.getDate();


$(".year").text(currentDate.getFullYear()+ "년");
$(".month").text(currentDate.getMonth() + 1 + "월");

$("#calender-prev").click(() => {
    currentDate = calendar.getDate();

    var prevDate = new Date(currentDate.getFullYear(), currentDate.getMonth() - 1, 1);
    var prevYear = prevDate.getFullYear();
    var prevMonthIndex = prevDate.getMonth();

    $(".year").text(prevYear+ "년");
    $(".month").text(prevMonthIndex + 1 + "월");

    calendar.prev();
});

$("#calender-next").click(() => {
    currentDate = calendar.getDate();

    var nextDate = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 1);
    var nextMonthIndex = nextDate.getMonth();
    var nextYear = nextDate.getFullYear();

    $(".year").text(nextYear+ "년");
    $(".month").text(nextMonthIndex + 1 + "월");

    calendar.next();
});

$(document).ready(function() {
    $('.toastui-calendar-daygrid-cell').on('click', function() {
        for(let i =0; i< 37;i++){
            clickedDay = $($('.toastui-calendar-daygrid-cell').children().children().children()[i])
            if(clickedDay.hasClass('toastui-calendar-weekday-grid-date-decorator')){
                clickedDay.removeClass('toastui-calendar-weekday-grid-date-decorator')
                clickedDay.css('color', 'black')
                $(this).children().children().children().addClass('toastui-calendar-weekday-grid-date-decorator')
                $(this).children().children().children().css('color', 'white')
            }

        }
    })

});
// $(document).ready(function() {
//     for (let i = 0; i < 37; i++) {
//         clickedDay = $($('.toastui-calendar-daygrid-cell').children().children().children()[i])
//         if (clickedDay.hasClass('toastui-calendar-weekday-grid-date-decorator')) {
//             clickedDay.removeClass('toastui-calendar-weekday-grid-date-decorator')
//             clickedDay.css('color', 'black')
//             $(this).children().children().children().addClass('toastui-calendar-weekday-grid-date-decorator')
//             $(this).children().children().children().css('color', 'white')
//         }
//
//     }
// });