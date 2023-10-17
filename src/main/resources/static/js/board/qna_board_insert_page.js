//summer-note
$(document).ready(function() {
    $('#summernote').summernote({
        height : 300,
        minHeight : null,
        maxHeight : null,
        focus : true,
        lang : 'ko-KR',
        // fontName : Dovemayo_gothic,
        // fontNameIgnoreCheck : Dovemayo_gothic,
        toolbar : [
            // [groupname, [list of button]]
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
            ['color', ['forecolor', 'color']],
            ['table', ['table']],
            ['para', ['ul', 'oi', 'paragraph']],
            ['height', ['height']],
        ],
        fontSize : ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72']
    });
  });
