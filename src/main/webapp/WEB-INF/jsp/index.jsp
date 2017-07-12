<!--
Author: StuDevs
Author URL: www.studevs.com
License:
License URL:
-->

<!Doctype html>
<html>
    <head>
        <title>Home | RESTful-in-Peace</title>
        <style type="text/css">

        </style>
    </head>
    <body>
        <div>
            <h1>Welcome to RESTful-in-Peace | Home Page</h1>
        </div>
        <div>
            <hr/>
            <h1>Testing</h1>
            <div>
                <h2>Create Admin</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/create" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <select name="adminPrivilege">
                        <option>ALL</option>
                        <option>CREATE</option>
                        <option>READ</option>
                        <option>UPDATE</option>
                        <option>DELETE</option>
                    </select><br/>
                    <input type="submit" value="Create Admin" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Update Patient</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/patient/update" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <input type="text" name="email" placeholder="Email" /> <br/>
                    <input type="text" name="firstName" placeholder="First Name" /> <br/>
                    <input type="text" name="lastName" placeholder="Last Name" /> <br/>
                    <input type="text" name="phone" placeholder="Phone" /> <br/>
                    <input type="text" name="address" placeholder="Address" /> <br/>
                    <input type="text" name="city" placeholder="City" /> <br/>
                    <input type="text" name="state" placeholder="State" /> <br/>
                    <input type="text" name="country" placeholder="Country" /> <br/>
                    <select name="gender">
                        <option>MALE</option>
                        <option>FEMALE</option>
                        <option>TRANSGENDER</option>
                        <option>SHEMALE</option>
                        <option>OTHER</option>
                    </select><br/>
                    <input type="date" name="birthDate" placeholder="Birth Date" /> <br/>
                    <input type="submit" value="Update Patient" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Update Doctor</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/doctor/update" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <input type="text" name="email" placeholder="Email" /> <br/>
                    <input type="text" name="firstName" placeholder="First Name" /> <br/>
                    <input type="text" name="lastName" placeholder="Last Name" /> <br/>
                    <input type="text" name="phone" placeholder="Phone" /> <br/>
                    <input type="text" name="address" placeholder="Address" /> <br/>
                    <input type="text" name="city" placeholder="City" /> <br/>
                    <input type="text" name="state" placeholder="State" /> <br/>
                    <input type="text" name="country" placeholder="Country" /> <br/>
                    <select name="gender">
                        <option>MALE</option>
                        <option>FEMALE</option>
                        <option>TRANSGENDER</option>
                        <option>SHEMALE</option>
                        <option>OTHER</option>
                    </select><br/>
                    <input type="date" name="birthDate" placeholder="Birth Date" /> <br/>
                    <input type="submit" value="Update Doctor" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>User Logout Testing</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/logout" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <select name="userType">
                        <option>PATIENT</option>
                        <option>DOCTOR</option>
                    </select><br/>
                    <input type="submit" value="Log Out" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Admin Logout Testing</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/logout" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="submit" value="Log Out" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>User Login Testing</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/login" method="POST">
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <select name="userType">
                        <option>PATIENT</option>
                        <option>DOCTOR</option>
                    </select><br/>
                    <input type="submit" value="Log In" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Admin Login Testing</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/login" method="POST">
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <input type="submit" value="Log In" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>New Doctor Creation</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/doctor" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <input type="text" name="email" placeholder="Email" /> <br/>
                    <input type="text" name="firstName" placeholder="First Name" /> <br/>
                    <input type="text" name="lastName" placeholder="Last Name" /> <br/>
                    <input type="text" name="phone" placeholder="Phone" /> <br/>
                    <input type="text" name="address" placeholder="Address" /> <br/>
                    <input type="text" name="city" placeholder="City" /> <br/>
                    <input type="text" name="state" placeholder="State" /> <br/>
                    <input type="text" name="country" placeholder="Country" /> <br/>
                    <select name="gender">
                        <option>MALE</option>
                        <option>FEMALE</option>
                        <option>TRANSGENDER</option>
                        <option>SHEMALE</option>
                        <option>OTHER</option>
                    </select><br/>
                    <input type="date" name="birthDate" placeholder="Birth Date" /> <br/>
                    <input type="submit" value="Create Doctor" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>New Patient Creation</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/patient" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <input type="text" name="email" placeholder="Email" /> <br/>
                    <input type="text" name="firstName" placeholder="First Name" /> <br/>
                    <input type="text" name="lastName" placeholder="Last Name" /> <br/>
                    <input type="text" name="phone" placeholder="Phone" /> <br/>
                    <input type="text" name="address" placeholder="Address" /> <br/>
                    <input type="text" name="city" placeholder="City" /> <br/>
                    <input type="text" name="state" placeholder="State" /> <br/>
                    <input type="text" name="country" placeholder="Country" /> <br/>
                    <select name="gender">
                        <option>MALE</option>
                        <option>FEMALE</option>
                        <option>TRANSGENDER</option>
                        <option>SHEMALE</option>
                        <option>OTHER</option>
                    </select><br/>
                    <input type="date" name="birthDate" placeholder="Birth Date" /> <br/>
                    <input type="submit" value="Create Patient" />
                </form>
            </div>
        </div>
        <div>
            <h1>API Documentation</h1>
        </div>
    </body>
</html>
