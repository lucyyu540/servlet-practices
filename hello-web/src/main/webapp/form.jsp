<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<form action="/hello-web/join" method='get'>
		<b>Email : </b><input type='text' name='email' value=''/>
		<b> Password : </b> <input type='password' name='password' value=''/>
		<br/><br/>
		
		<b>Year of birth : </b>
		<select name='birthYear'>
			<option value="1994">1994</option>
			<option value="1995">1995</option>
			<option value="1996">1996</option>
		</select>
		<br/><br/>
		
		<b>Sex :</b>
		F<input type='radio' name='gender' value='f'/>
		M<input type='radio' name='gender' value='m'/>
		<br/><br/>
		
		<b>Hobbies </b> <br/>
		jogging<input type='checkbox' name='hobbies' value='jogging'/>
		swimming<input type='checkbox' name='hobbies' value='swimming'/>
		<br/><br/>
		
		<b>Self-introduction: </b><br/>
		<textarea name="intro"></textarea>		
		<br/><br/>
		<input type='submit' value='register'/>
	</form>

</body>
</html>