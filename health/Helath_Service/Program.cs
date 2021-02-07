using System;
using System.Text;
using System.Data;
using System.Net.Mail;
using Newtonsoft.Json;
using System.Net.Http;
using System.Net.Http.Headers;
using Newtonsoft.Json.Linq;
using System.Linq;

namespace Helath_Service
{
    public class Program
    {
        private static HttpClient _httpClient = new HttpClient();
		
        static void Main(string[] args)
        {
            getmailcontent();
        }
		
        public static void getmailcontent()
        {
            _httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MTA3MDM1NjIsImV4cCI6MTY0MjI2MTE2MiwiYXVkIjoiNjAwMTYyOTg3YzdjMzI3ODkwZmUxMjQ1IiwiaXNzIjoiZ29vZ2xlLmNvbSJ9.OjtWvZliGjFYL9tr7Pien5-Lp7FezKxzNbPh0S__GnM");

            var obj = ""; string mailBodyContent = "";


            var myContent = JsonConvert.SerializeObject(obj);

            var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
            var byteContent = new ByteArrayContent(buffer);
            byteContent.Headers.ContentType = new MediaTypeHeaderValue("application/json");


            HttpResponseMessage result = _httpClient.PostAsync("https://medimok-m.herokuapp.com/doctor/sensor/abnormal", null).Result;
            if (result.StatusCode == System.Net.HttpStatusCode.OK)
            {


                string returnValue = result.Content.ReadAsStringAsync().Result; // here we get data

                DataTable dtNewtonSoftLinq = ConvertJsonToDatatableLinq(returnValue);	// json data to datatable
                dtNewtonSoftLinq.Columns.Remove("address");
                dtNewtonSoftLinq.Columns.Remove("city");
                dtNewtonSoftLinq.Columns.Remove("state");
                dtNewtonSoftLinq.Columns.Remove("county");
                dtNewtonSoftLinq.Columns.Remove("postalcode");
                dtNewtonSoftLinq.Columns.Remove("knownName");
                dtNewtonSoftLinq.Columns.Remove("phone");
                dtNewtonSoftLinq.Columns.Remove("registerno");
                dtNewtonSoftLinq.Columns.Remove("respiration");
                dtNewtonSoftLinq.Columns.Remove("cardiogram");
                dtNewtonSoftLinq.Columns.Remove("asthma");
                dtNewtonSoftLinq.Columns.Remove("headaches");
                dtNewtonSoftLinq.Columns.Remove("anxiety");
                dtNewtonSoftLinq.Columns.Remove("longitude");
                dtNewtonSoftLinq.Columns.Remove("latitude");
                
                for (int count = 0; count < dtNewtonSoftLinq.Rows.Count; count++)  //Please remove this statement the for condition when your testing is complete
                //for (int count = 0; count < dtNewtonSoftLinq.Rows.Count; count++) //uncommend this line after your testing
                {
                    string bodyTemperature = dtNewtonSoftLinq.Rows[count][0].ToString();
                    string bloodPressure = dtNewtonSoftLinq.Rows[count][1].ToString();
                    string glucose = dtNewtonSoftLinq.Rows[count][2].ToString();
                    string heartRate = dtNewtonSoftLinq.Rows[count][3].ToString();
                    string cholesterol = dtNewtonSoftLinq.Rows[count][4].ToString();
                    string oxygen = dtNewtonSoftLinq.Rows[count][5].ToString();
                    string depression = dtNewtonSoftLinq.Rows[count][6].ToString();
                    string sugar = dtNewtonSoftLinq.Rows[count][7].ToString();
                    string status = dtNewtonSoftLinq.Rows[count][8].ToString();
                    string update = dtNewtonSoftLinq.Rows[count][9].ToString();
                    string firstname = dtNewtonSoftLinq.Rows[count][10].ToString();
                    string lastname = dtNewtonSoftLinq.Rows[count][11].ToString();
                    string email = dtNewtonSoftLinq.Rows[count][12].ToString();
                    string companyname = dtNewtonSoftLinq.Rows[count][13].ToString();
                    
                    mailBodyContent = "<br/> <br/> <br/><b> Name: </b>" + firstname+" " + lastname;
                    
                    mailBodyContent += "<br/><b>Company Name: </b>" + companyname+ "<br/> ";
                    
                    mailBodyContent += " <br/> <table border=" + 1 + " cellpadding=" + 0 + " cellspacing=" + 0 + " width = " + 100 + "%>" +
                    "<tr bgcolor='#4da6ff'>" +
                    "<td><b>Body Temperature</b></td> <td> <b>BP</b> </td> <td> <b>Glucose</b> </td>" +
                    " <td> <b>Glucose</b> </td> <td> <b>Heart Rate</b> </td> <td> <b>Cholesterol</b> </td> <td> <b>Oxygen</b> </td> <td> <b>Depression</b> </td> <td> <b>Sugar</b> </td> " + "</tr>"+
                    "<tr><td>" + bodyTemperature + "</td>" +"<td>" + bloodPressure + "</td>" + "<td>" + glucose + "</td>" + "<td>" + heartRate + "</td>" +
                    "<td>" + cholesterol + "</td>" + "<td>" + oxygen + "</td>" + "<td>" + depression + "</td>" + "<td>" + sugar + "</td>" + "</tr>";
                    mailBodyContent += "</table> <br/> <br/> <br/>";

                    mailBodyContent += "<p><b>Last Report Update Date :</b>" + update+ "</p>";
                    mailBodyContent += "<b>Over All Status : </b>" + status + "<br/>";

                    mailBodyContent += "<center><h2 style=\"color:#990500\">Please Consider to doctor</center></h2>";
                    email = "kavitcs455@gmail.com";
                    EmployeeMailSent(email, mailBodyContent);
                }
            }

        }
		
		// convert the api json data to datatable
        public static DataTable ConvertJsonToDatatableLinq(string jsonString)
        {
            var jsonLinq = JObject.Parse(jsonString);

            var linqArray = jsonLinq.Descendants().Where(x => x is JArray).First();
            var jsonArray = new JArray();
            foreach (JObject row in linqArray.Children<JObject>())
            {
                var createRow = new JObject();
                foreach (JProperty column in row.Properties())
                {
                    if (column.Value is JValue)
                        createRow.Add(column.Name, column.Value);
                }
                jsonArray.Add(createRow);
            }

            return JsonConvert.DeserializeObject<DataTable>(jsonArray.ToString());
        }
		
		// here this function send email to the employee
        public static void EmployeeMailSent(string to, string content)
        {
            string from = "noreplymedonline@gmail.com"; //From address    
            MailMessage message = new MailMessage(from, to);

            string mailbody = content;
            message.Subject = "Mail from Med Online";
            message.Body = mailbody;
            message.IsBodyHtml = true;
            message.BodyEncoding = Encoding.UTF8;
            SmtpClient client = new SmtpClient("smtp.gmail.com", 587);

            
            System.Net.NetworkCredential basicCredential1 = new

            System.Net.NetworkCredential("noreplymedonline@gmail.com", "med123@#");

            client.EnableSsl = true;
            client.UseDefaultCredentials = false;
            client.Credentials = basicCredential1;
            try
            {
                client.Send(message);
            }

            catch (Exception ex)
            {
                throw ex;
            }
        }
    }
}
