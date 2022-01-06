var main ={
  init : function (){
    var _this = this;
    $('#btn-save').on('click',function(){
      _this.save();
    })
    $('#sidebar-btn').on('click',function(){
      _this.toggleSidebar();
    })
    $('#create-quiz-next-btn').on('click',function (){
      _this.toggleMCQuizCreate();
    })
    $('#create-quiz-before-btn').on('click',function () {
      _this.toggleMCQuizCreate();
    })
    //form-group-mc 숨기는 로직
    $('.form-group-mc').hide();
  },
  toggleMCQuizCreate : function(){
    $('.form-group-before').toggle();
    $('.form-group-mc').toggle();
  },
  save : function (){
    var data = {
      name : $('#name').val()
    };
    $.ajax({
      type : 'POST',
      dateType : 'json',
      contentType : 'application/json; charset=utf-8',
      data : JSON.stringify(data)
    }).done(function (){
      alert('새로운 카테고리가 등록되었습니다.');
      window.location.href='/';
    }).fail(function (error){
      alert(JSON.stringify(error));
    })
  },
  toggleSidebar : function(){
    $('#sidebar').toggle();
  }
}

main.init();