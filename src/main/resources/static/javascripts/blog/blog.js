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
      alert("Data: " + data + "\nStatus: " + status);
    });
}
