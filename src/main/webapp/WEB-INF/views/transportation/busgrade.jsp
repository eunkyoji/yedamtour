<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
const txt = {
				"response":{
					"body":{
						"items":{
							"item":[
								{
									"gradeNm":"프리미엄"
								},
								{
									"gradeNm":"일반"
								},
								{
									"gradeNm":"우등"
								},
								{
									"gradeNm":"주말프리"
								},
								{
									"gradeNm":"심야프리"
								},
								{
									"gradeNm":"심야일반"
								},
								{
									"gradeNm":"심야우등"
								},
								{
									"gradeNm":"주말심프"
								}
							]
						}
					}
				}
			}
			
let datas= txt.response.body.items.item;
datas.forEach(data =>{
	console.log(data.gradeNm)
})
</script>
</body>
</html>