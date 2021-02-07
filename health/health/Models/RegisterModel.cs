using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace HealthZonemr.Models
{
    public class DoctorRegisterModel
    {
            public string firstname { get; set; }
            public string lastname { get; set; }
            public string email { get; set; }
            public string password { get; set; }
            public string phone { get; set; }
            public string doctorid { get; set; }
    }
    public class EmployeeRegisterModel
    {
        public string firstname { get; set; }
        public string lastname { get; set; }
        public string email { get; set; }
        public string password { get; set; }
        public string phone { get; set; }
        public string registerno { get; set; }
        public string companyname { get; set; }
    }
}