function commentSubmit() {
  var blogId = $("#blogId").val();
  var reader = $("#reader").val();
  var comment = $("#comment").val();

  $.post("/blog/comment",
    {
      blogId: blogId,
      reader: reader,
      comment: comment
    },
    function (data, status) {
      if (status != 'success' || !data.status) {
        alert('发布失败，请重试！');
        return false;
      }
      alert('评论成功！');
      $("#reader").val("");
      $("#comment").val("");
      window.location.reload();
    });
}
