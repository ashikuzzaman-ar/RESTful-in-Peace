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
                <h2>Get Patients</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/patient/get" method="GET">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <select name="userType">
                        <option>PATIENT</option>
                        <option>DOCTOR</option>
                        <option>ADMIN</option>
                    </select><br/>
                    <input type="text" name="from" placeholder="From" /> <br/>
                    <input type="text" name="to" placeholder="To" /> <br/>
                    <input type="submit" value="Get Patients" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Get Doctors</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/doctor/get" method="GET">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <select name="userType">
                        <option>PATIENT</option>
                        <option>DOCTOR</option>
                        <option>ADMIN</option>
                    </select><br/>
                    <input type="text" name="from" placeholder="From" /> <br/>
                    <input type="text" name="to" placeholder="To" /> <br/>
                    <input type="submit" value="Get Doctors" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Update Visiting By Doctor</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/visiting/update/doctor" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="id" placeholder="Visiting ID" /> <br/>
                    <input type="text" name="symptoms" placeholder="Symptoms" /> <br/>
                    <input type="text" name="prediction" placeholder="Prediction" /> <br/>
                    <input type="text" name="suggestions" placeholder="Suggestions" /> <br/>
                    <input type="submit" value="Update Visiting" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Update Visiting By Patient</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/visiting/update/patient" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="id" placeholder="Visiting ID" /> <br/>
                    <span>This was effective </span><input type="checkbox" name="isEffective" value="true" /><br/>
                    <input type="submit" value="Update Visiting" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Create Visiting</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/visiting/create" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="doctorId" placeholder="Doctor ID" /> <br/>
                    <input type="text" name="doctorFee" placeholder="Doctor Fee" /> <br/>
                    <input type="date" name="visitingDate" placeholder="Visiting Date" /> <br/>
                    <input type="submit" value="Create Visiting" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Delete Doctor</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/doctor/delete" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="submit" value="Delete Doctor" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Delete Patient</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/user/patient/delete" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="submit" value="Delete Patient" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Get Admins</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/get" method="GET">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="from" placeholder="From" /> <br/>
                    <input type="text" name="to" placeholder="To" /> <br/>
                    <input type="submit" value="Get Admins" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Delete Admin</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/delete" method="POST">
                    <input type="text" name="token" placeholder="Token" /> <br/>
                    <input type="text" name="id" placeholder="id" /> <br/>
                    <input type="text" name="username" placeholder="Username" /> <br/>
                    <input type="password" name="password" placeholder="Password" /> <br/>
                    <select name="adminPrivilege">
                        <option>ALL</option>
                        <option>CREATE</option>
                        <option>READ</option>
                        <option>UPDATE</option>
                        <option>DELETE</option>
                    </select><br/>
                    <input type="submit" value="Delete Admin" />
                </form>
            </div>
            <br/>
            <hr/>
            <div>
                <h2>Update Admin</h2>
                <form action="http://localhost:<%= request.getLocalPort()%>/Rest_in_Peace/services/api/admin/update" method="POST">
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
                    <input type="submit" value="Update Admin" />
                </form>
            </div>
            <br/>
            <hr/>
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
            <div>
                <hr/>
                <div>
                    <h1>Admin Login API Documentation</h1>
                    <div id="admin_login">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Password of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/admin/login" method="POST"&gt;
&lt;input type="text" name="username" placeholder="Username"/&gt;&lt;br/&gt;
&lt;input type="password" name="password" placeholder="Password"/&gt;&lt;br/&gt;
&lt;input type="submit" value="Login" /&gt;
&lt;/form&gt;
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"username": "ashik",
"token": "3EC9bB5fE7cfC7af91257efcCec3D5bc79c9222C2B23D5ac792CB37B5fD5B9fD",
"adminPrivilege": "ALL",
"userType": "ADMIN"
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Create Admin API Documentation</h1>
                    <div id="admin_create">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username of new admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Password of new admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>adminPrivilege</td>
                                        <td>string/text[ALL/CREATE/READ/UPDATE/DELETE]</td>
                                        <td>Privilege of new admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/admin/create" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;select name="adminPrivilege">
&lt;option>ALL&lt;/option>
&lt;option>CREATE&lt;/option>
&lt;option>READ&lt;/option>
&lt;option>UPDATE&lt;/option>
&lt;option>DELETE&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="submit" value="Create Admin" />
&lt;/form&gt;
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Insertion : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Update Admin API Documentation</h1>
                    <div id="admin_update">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username of admin</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Password of admin</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>adminPrivilege</td>
                                        <td>string/text[ALL/CREATE/READ/UPDATE/DELETE]</td>
                                        <td>Privilege of admin</td>
                                        <td>Optional</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/admin/update" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;select name="adminPrivilege">
&lt;option>ALL&lt;/option>
&lt;option>CREATE&lt;/option>
&lt;option>READ&lt;/option>
&lt;option>UPDATE&lt;/option>
&lt;option>DELETE&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="submit" value="Update Admin" />
&lt;/form&gt;
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
[
{
"messages": [
"Update : true"
]
},
{
"username": "ashik",
"token": "579Ce559BE7C9aD3b7DCD1eB999fA3a57Ac9fAACeaBf9D3Aaff95B25A2eCCAca",
"adminPrivilege": "ALL",
"userType": "ADMIN"
}
]
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Delete Admin API Documentation</h1>
                    <div id="admin_delete">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>id</td>
                                        <td>int/long</td>
                                        <td>Id of admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username of admin</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Password of admin</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>adminPrivilege</td>
                                        <td>string/text[ALL/CREATE/READ/UPDATE/DELETE]</td>
                                        <td>Privilege of new admin</td>
                                        <td>Optional</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/admin/delete" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="id" placeholder="ID" /> &lt;br/>
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;select name="adminPrivilege">
&lt;option>ALL&lt;/option>
&lt;option>CREATE&lt;/option>
&lt;option>READ&lt;/option>
&lt;option>UPDATE&lt;/option>
&lt;option>DELETE&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="submit" value="Delete Admin" />
&lt;/form&gt;
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Delete : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Get Admins API Documentation</h1>
                    <div id="admins_get">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>from</td>
                                        <td>int/long</td>
                                        <td>Initial id of an admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>to</td>
                                        <td>int/long</td>
                                        <td>Terminal id of an admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/admin/get" method="GET">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="from" placeholder="From" /> &lt;br/>
&lt;input type="text" name="to" placeholder="To" /> &lt;br/>
&lt;input type="submit" value="Get Admins" />
&lt;/form&gt;
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
[
{
"username": "ashif",
"token": null,
"adminPrivilege": "CREATE",
"userType": "ADMIN"
},
{
"username": "akash",
"token": null,
"adminPrivilege": "UPDATE",
"userType": "ADMIN"
}
]
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Admin Logout API Documentation</h1>
                    <div id="admin_logout">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Generated token for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/logout" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="submit" value="Log Out" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Logout successful!"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Create New Patient API Documentation</h1>
                    <div id="create_new_patient">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>email</td>
                                        <td>string/text</td>
                                        <td>Email for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>firstName</td>
                                        <td>string/text</td>
                                        <td>First name of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>lastName</td>
                                        <td>string/text</td>
                                        <td>Last name of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>phone</td>
                                        <td>string/text</td>
                                        <td>Phone number of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>address</td>
                                        <td>string/text</td>
                                        <td>Address of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>city</td>
                                        <td>string/text</td>
                                        <td>City, where user lives in</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>state</td>
                                        <td>string/text</td>
                                        <td>State, where user lives in</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>country</td>
                                        <td>string/text</td>
                                        <td>Country, where user lives in</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>gender</td>
                                        <td>string/text[MALE/FEMALE/TRANSGENDER/SHEMALE/OTHER]</td>
                                        <td>Gender of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>birthDate</td>
                                        <td>date/date-time</td>
                                        <td>Gender of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/admin/patient" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;input type="text" name="email" placeholder="Email" /> &lt;br/>
&lt;input type="text" name="firstName" placeholder="First Name" /> &lt;br/>
&lt;input type="text" name="lastName" placeholder="Last Name" /> &lt;br/>
&lt;input type="text" name="phone" placeholder="Phone" /> &lt;br/>
&lt;input type="text" name="address" placeholder="Address" /> &lt;br/>
&lt;input type="text" name="city" placeholder="City" /> &lt;br/>
&lt;input type="text" name="state" placeholder="State" /> &lt;br/>
&lt;input type="text" name="country" placeholder="Country" /> &lt;br/>
&lt;select name="gender">
&lt;option>MALE&lt;/option>
&lt;option>FEMALE&lt;/option>
&lt;option>TRANSGENDER&lt;/option>
&lt;option>SHEMALE&lt;/option>
&lt;option>OTHER&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="date" name="birthDate" placeholder="Birth Date" /> &lt;br/>
&lt;input type="submit" value="Create Patient" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Insertion : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Update Patient API Documentation</h1>
                    <div id="update_patient">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>email</td>
                                        <td>string/text</td>
                                        <td>Email for the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>firstName</td>
                                        <td>string/text</td>
                                        <td>First name of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>lastName</td>
                                        <td>string/text</td>
                                        <td>Last name of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>phone</td>
                                        <td>string/text</td>
                                        <td>Phone number of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>address</td>
                                        <td>string/text</td>
                                        <td>Address of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>city</td>
                                        <td>string/text</td>
                                        <td>City, where user lives in</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>state</td>
                                        <td>string/text</td>
                                        <td>State, where user lives in</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>country</td>
                                        <td>string/text</td>
                                        <td>Country, where user lives in</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>gender</td>
                                        <td>string/text[MALE/FEMALE/TRANSGENDER/SHEMALE/OTHER]</td>
                                        <td>Gender of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>birthDate</td>
                                        <td>date/date-time</td>
                                        <td>Gender of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/patient/update" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;input type="text" name="email" placeholder="Email" /> &lt;br/>
&lt;input type="text" name="firstName" placeholder="First Name" /> &lt;br/>
&lt;input type="text" name="lastName" placeholder="Last Name" /> &lt;br/>
&lt;input type="text" name="phone" placeholder="Phone" /> &lt;br/>
&lt;input type="text" name="address" placeholder="Address" /> &lt;br/>
&lt;input type="text" name="city" placeholder="City" /> &lt;br/>
&lt;input type="text" name="state" placeholder="State" /> &lt;br/>
&lt;input type="text" name="country" placeholder="Country" /> &lt;br/>
&lt;select name="gender">
&lt;option>MALE&lt;/option>
&lt;option>FEMALE&lt;/option>
&lt;option>TRANSGENDER&lt;/option>
&lt;option>SHEMALE&lt;/option>
&lt;option>OTHER&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="date" name="birthDate" placeholder="Birth Date" /> &lt;br/>
&lt;input type="submit" value="Update Patient" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
[
{
"messages": [
"Update successful!"
]
},
{
"id": 1,
"token": "DE7e7e275312bAC12CB3eDDE53c25fe9c3AEc2Ae399EAf5fC1cfc5a75B2fECbC",
"email": "u1@gmail.com",
"firstName": "fn",
"lastName": "ln",
"phone": "phn",
"address": "add",
"city": "cit",
"state": "stt",
"country": "cnt",
"gender": "MALE",
"visitings": null,
"dateOfBirth": "Mon May 10 00:00:00 BDT 1993",
"userType": "PATIENT"
}
]
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Delete Patient API Documentation</h1>
                    <div id="delete_patient">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the patient</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/patient/delete" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="submit" value="Delete Patient" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Delete : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Create New Doctor API Documentation</h1>
                    <div id="create_new_doctor">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the admin</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>email</td>
                                        <td>string/text</td>
                                        <td>Email for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>firstName</td>
                                        <td>string/text</td>
                                        <td>First name of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>lastName</td>
                                        <td>string/text</td>
                                        <td>Last name of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>phone</td>
                                        <td>string/text</td>
                                        <td>Phone number of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>address</td>
                                        <td>string/text</td>
                                        <td>Address of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>city</td>
                                        <td>string/text</td>
                                        <td>City, where user lives in</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>state</td>
                                        <td>string/text</td>
                                        <td>State, where user lives in</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>country</td>
                                        <td>string/text</td>
                                        <td>Country, where user lives in</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>gender</td>
                                        <td>string/text[MALE/FEMALE/TRANSGENDER/SHEMALE/OTHER]</td>
                                        <td>Gender of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>birthDate</td>
                                        <td>date/date-time</td>
                                        <td>Gender of the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/admin/doctor" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;input type="text" name="email" placeholder="Email" /> &lt;br/>
&lt;input type="text" name="firstName" placeholder="First Name" /> &lt;br/>
&lt;input type="text" name="lastName" placeholder="Last Name" /> &lt;br/>
&lt;input type="text" name="phone" placeholder="Phone" /> &lt;br/>
&lt;input type="text" name="address" placeholder="Address" /> &lt;br/>
&lt;input type="text" name="city" placeholder="City" /> &lt;br/>
&lt;input type="text" name="state" placeholder="State" /> &lt;br/>
&lt;input type="text" name="country" placeholder="Country" /> &lt;br/>
&lt;select name="gender">
&lt;option>MALE&lt;/option>
&lt;option>FEMALE&lt;/option>
&lt;option>TRANSGENDER&lt;/option>
&lt;option>SHEMALE&lt;/option>
&lt;option>OTHER&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="date" name="birthDate" placeholder="Birth Date" /> &lt;br/>
&lt;input type="submit" value="Create Doctor" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Insertion : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Update Doctor API Documentation</h1>
                    <div id="update_doctor">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the doctor</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>email</td>
                                        <td>string/text</td>
                                        <td>Email for the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>firstName</td>
                                        <td>string/text</td>
                                        <td>First name of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>lastName</td>
                                        <td>string/text</td>
                                        <td>Last name of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>phone</td>
                                        <td>string/text</td>
                                        <td>Phone number of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>address</td>
                                        <td>string/text</td>
                                        <td>Address of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>city</td>
                                        <td>string/text</td>
                                        <td>City, where user lives in</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>state</td>
                                        <td>string/text</td>
                                        <td>State, where user lives in</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>country</td>
                                        <td>string/text</td>
                                        <td>Country, where user lives in</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>gender</td>
                                        <td>string/text[MALE/FEMALE/TRANSGENDER/SHEMALE/OTHER]</td>
                                        <td>Gender of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>birthDate</td>
                                        <td>date/date-time</td>
                                        <td>Gender of the user</td>
                                        <td>Optional</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/doctor/update" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;input type="text" name="email" placeholder="Email" /> &lt;br/>
&lt;input type="text" name="firstName" placeholder="First Name" /> &lt;br/>
&lt;input type="text" name="lastName" placeholder="Last Name" /> &lt;br/>
&lt;input type="text" name="phone" placeholder="Phone" /> &lt;br/>
&lt;input type="text" name="address" placeholder="Address" /> &lt;br/>
&lt;input type="text" name="city" placeholder="City" /> &lt;br/>
&lt;input type="text" name="state" placeholder="State" /> &lt;br/>
&lt;input type="text" name="country" placeholder="Country" /> &lt;br/>
&lt;select name="gender">
&lt;option>MALE&lt;/option>
&lt;option>FEMALE&lt;/option>
&lt;option>TRANSGENDER&lt;/option>
&lt;option>SHEMALE&lt;/option>
&lt;option>OTHER&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="date" name="birthDate" placeholder="Birth Date" /> &lt;br/>
&lt;input type="submit" value="Update Doctor" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
[
{
"messages": [
"Update successful!"
]
},
{
"id": 1,
"token": "DE7e7e275312bAC12CB3eDDE53c25fe9c3AEc2Ae399EAf5fC1cfc5a75B2fECbC",
"email": "u1@gmail.com",
"firstName": "fn",
"lastName": "ln",
"phone": "phn",
"address": "add",
"city": "cit",
"state": "stt",
"country": "cnt",
"gender": "FEMALE",
"visitings": null,
"dateOfBirth": "Mon May 10 00:00:00 BDT 1993",
"userType": "DOCTOR"
}
]
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Delete Doctor API Documentation</h1>
                    <div id="delete_doctor">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Token of the doctor</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/doctor/delete" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="submit" value="Delete Doctor" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Delete : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>User Login API Documentation</h1>
                    <div id="user_login">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>username</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>password</td>
                                        <td>string/text</td>
                                        <td>Username for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>userType</td>
                                        <td>string/text[PATIENT/DOCTOR]</td>
                                        <td>Email for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/login" method="POST">
&lt;input type="text" name="username" placeholder="Username" /> &lt;br/>
&lt;input type="password" name="password" placeholder="Password" /> &lt;br/>
&lt;select name="userType">
&lt;option>PATIENT&lt;/option>
&lt;option>DOCTOR&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="submit" value="Log In" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"id": 1,
"token": "e92EBfbaa7cbef555C5ee5BEBcAeEB5ae31DD5eCC133Eb2b11c2C1cAfB7a72b7",
"email": "JeremyCJohnson@rhyta.com",
"firstName": "Jeremy",
"lastName": "C. Johnson",
"phone": "804-628-2745",
"address": "2298 Biddie Lane",
"city": "Richmond, VA 23219 ",
"state": "Richmond",
"country": "USA",
"gender": "MALE",
"visitings": [
{
"id": 3,
"doctorFee": 900.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2018-03-07 00:00:00.0"
},
{
"id": 4,
"doctorFee": 1000.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2018-02-07 00:00:00.0"
}
],
"dateOfBirth": "1960-09-12",
"userType": "PATIENT"
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>User Logout API Documentation</h1>
                    <div id="user_logout">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Generated token for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>userType</td>
                                        <td>string/text[PATIENT/DOCTOR]</td>
                                        <td>Email for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/logout" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;select name="userType">
&lt;option>PATIENT&lt;/option>
&lt;option>DOCTOR&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="submit" value="Log Out" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Logout successful!"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Create Visiting API Documentation</h1>
                    <div id="create_visiting">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Generated token for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>doctorId</td>
                                        <td>int/long</td>
                                        <td>Id for the targeted doctor</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>doctorFee</td>
                                        <td>double/float/int</td>
                                        <td>Doctor's visiting fee</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>visitingDate</td>
                                        <td>date/date-time</td>
                                        <td>Doctor's visiting date</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/visiting/create" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="doctorId" placeholder="Doctor ID" /> &lt;br/>
&lt;input type="text" name="doctorFee" placeholder="Doctor Fee" /> &lt;br/>
&lt;input type="date" name="visitingDate" placeholder="Visiting Date" /> &lt;br/>
&lt;input type="submit" value="Create Visiting" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Insertion : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Update Visiting(Patient Side) API Documentation</h1>
                    <div id="update_patient_visiting">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Generated token for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>id</td>
                                        <td>int/long</td>
                                        <td>Id of the visiting entry</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>isEffective</td>
                                        <td>boolean</td>
                                        <td>Effectiveness of doctor's prescription</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/visiting/update/patient" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="id" placeholder="Visiting ID" /> &lt;br/>
&lt;span>This was effective &lt;/span>&lt;input type="checkbox" name="isEffective" value="true" />&lt;br/>
&lt;input type="submit" value="Update Visiting" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Update : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Update Visiting(Doctor Side) API Documentation</h1>
                    <div id="update_doctor_visiting">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Generated token for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>id</td>
                                        <td>int/long</td>
                                        <td>Id of the visiting entry</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>symptoms</td>
                                        <td>string/text</td>
                                        <td>Patient symptoms</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>prediction</td>
                                        <td>string/text</td>
                                        <td>Doctor's prediction on patient's symptoms</td>
                                        <td>Optional</td>
                                    </tr>
                                    <tr>
                                        <td>suggestions</td>
                                        <td>string/text</td>
                                        <td>Doctor's suggestions</td>
                                        <td>Optional</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/visiting/update/doctor" method="POST">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;input type="text" name="id" placeholder="Visiting ID" /> &lt;br/>
&lt;input type="text" name="symptoms" placeholder="Symptoms" /> &lt;br/>
&lt;input type="text" name="prediction" placeholder="Prediction" /> &lt;br/>
&lt;input type="text" name="suggestions" placeholder="Suggestions" /> &lt;br/>
&lt;input type="submit" value="Update Visiting" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
{
"messages": [
"Update : true"
]
}
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Get Doctors API Documentation</h1>
                    <div id="get_doctors">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Generated token for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>userType</td>
                                        <td>string/text[PATIENT/DOCTOR/ADMIN]</td>
                                        <td>User type of current session</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>from</td>
                                        <td>int/long</td>
                                        <td>Initial doctor's id</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>to</td>
                                        <td>int/long</td>
                                        <td>Terminal doctor's id</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/doctor/get" method="GET">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;select name="userType">
&lt;option>PATIENT&lt;/option>
&lt;option>DOCTOR&lt;/option>
&lt;option>ADMIN&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="text" name="from" placeholder="From" /> &lt;br/>
&lt;input type="text" name="to" placeholder="To" /> &lt;br/>
&lt;input type="submit" value="Get Doctors" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
[
{
"id": 2,
"token": null,
"email": "TonyaPSchisler@dayrep.com",
"firstName": "Tonya",
"lastName": "P. Schisler",
"phone": "228-623-2964",
"address": "3541 O Conner Street",
"city": "Gulfport, MS 39501 ",
"state": "Gulfport",
"country": "USA",
"gender": "FEMALE",
"visitings": [
{
"id": 3,
"doctorFee": 900.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": true,
"dateofVisiting": "2017-07-13 07:41:52.0"
},
{
"id": 7,
"doctorFee": 1000.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2018-03-07 00:00:00.0"
},
{
"id": 8,
"doctorFee": 1000.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2018-03-07 00:00:00.0"
}
],
"dateOfBirth": "1958-02-05",
"userType": "DOCTOR"
},
{
"id": 3,
"token": null,
"email": "DonaldJJones@dayrep.com ",
"firstName": "Donald",
"lastName": "J. Jones",
"phone": "0353 1696839",
"address": "Via Loreto, 80",
"city": "63044-Comunanza AP ",
"state": "Comunanza AP",
"country": "Italy",
"gender": "MALE",
"visitings": [
{
"id": 6,
"doctorFee": 1000.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2018-07-07 00:00:00.0"
},
{
"id": 2,
"doctorFee": 700.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2018-07-07 00:00:00.0"
}
],
"dateOfBirth": "1970-01-22",
"userType": "DOCTOR"
}
]
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
                <div>
                    <h1>Get Patients API Documentation</h1>
                    <div id="get_patients">
                        <div>
                            <h2>Attribute Table</h2>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Attribute Name</th>
                                        <th>Data Type</th>
                                        <th>Description</th>
                                        <th>Characteristics</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>token</td>
                                        <td>string/text</td>
                                        <td>Generated token for the user</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>userType</td>
                                        <td>string/text[PATIENT/DOCTOR/ADMIN]</td>
                                        <td>User type of current session</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>from</td>
                                        <td>int/long</td>
                                        <td>Initial patient's id</td>
                                        <td>Mandatory</td>
                                    </tr>
                                    <tr>
                                        <td>to</td>
                                        <td>int/long</td>
                                        <td>Terminal patient's id</td>
                                        <td>Mandatory</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <h3>Examples</h3>
                            <div>
                                <pre>
                                <code style="font-size: xx-large;">
&lt;form action="http://restfulinpeace-studevs.rhcloud.com/services/api/user/patient/get" method="GET">
&lt;input type="text" name="token" placeholder="Token" /> &lt;br/>
&lt;select name="userType">
&lt;option>PATIENT&lt;/option>
&lt;option>DOCTOR&lt;/option>
&lt;option>ADMIN&lt;/option>
&lt;/select>&lt;br/>
&lt;input type="text" name="from" placeholder="From" /> &lt;br/>
&lt;input type="text" name="to" placeholder="To" /> &lt;br/>
&lt;input type="submit" value="Get Patients" />
&lt;/form>
                                </code>
                                </pre>
                                <div>
                                    <h2>Successful Response</h2>
                                    <pre>
                                        <code style="font-size: xx-large;">
[
{
"id": 3,
"token": null,
"email": "KimberlyMPatterson@dayrep.com ",
"firstName": "Kimberly",
"lastName": "M. Patterson",
"phone": "504-866-3244",
"address": "1481 Shadowmar Drive",
"city": "New Orleans, LA 70118 ",
"state": "New Orleans",
"country": "USA",
"gender": "FEMALE",
"visitings": [
{
"id": 1,
"doctorFee": 1000.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2019-05-07 00:00:00.0"
},
{
"id": 2,
"doctorFee": 700.0,
"symptoms": null,
"prediction": null,
"suggestions": null,
"isEffective": null,
"dateofVisiting": "2018-07-07 00:00:00.0"
}
],
"dateOfBirth": "1957-07-24",
"userType": "PATIENT"
},
{
"id": 4,
"token": null,
"email": "JacklynSHilton@jourrapide.com",
"firstName": "Jacklyn",
"lastName": "S. Hilton",
"phone": "301-948-8248",
"address": "3065 Lake Floyd Circle",
"city": "Gaithersburg, MD 20877 ",
"state": "Gaithersburg",
"country": "USA",
"gender": "FEMALE",
"visitings": [],
"dateOfBirth": "1969-07-26",
"userType": "PATIENT"
},
{
"id": 5,
"token": null,
"email": "JanEMurray@armyspy.com",
"firstName": "Jan",
"lastName": "E. Murray",
"phone": "413-534-3984",
"address": "3454 Kinney Street",
"city": "Holyoke, MA 01040 ",
"state": "Holyoke",
"country": "USA",
"gender": "FEMALE",
"visitings": [],
"dateOfBirth": "1987-06-16",
"userType": "PATIENT"
}
]
                                        </code>
                                    </pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr/>
            </div>
        </div>
    </body>
</html>
