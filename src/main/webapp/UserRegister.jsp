<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register</title>
</head>
<body>
  <form action="./AddUser" method="post" name="userform">
                      
                        <div class="form-group">
                            <input type="text" id="log_clientname"  name="user_name"  class="form-control" required="required" placeholder="Enter  Username"/>
                        </div>
                        <div class="form-group">
                            <input type="text"  id="log_clientpw" name="user_pwd" class="form-control" required="required" placeholder="Enter Login Password" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" required="required" placeholder="Retype  Password" />
                        </div>

                       <div class="form-group ">
                            <button type="submit" class="btn btn-primary">Register</button>
                            <button type="reset" class="btn btn-primary">Reset</button>
                            
                        </div>
  </form>
</body>
</html>