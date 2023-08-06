const calendar = new Calendar('#calendar', {
    defaultView: 'week',
    useCreationPopup: true,
    useDetailPopup: true
});
calendar.render();
calendar.createSchedules([
    {
        id: '1',
        calendarId: 'Major Lecture',
        title: '10000원  ',
        category: 'time',
        start: '2023-05-27',
        end: '2023-05-27',
        isReadOnly: true // schedule is read-only
    }
]);

