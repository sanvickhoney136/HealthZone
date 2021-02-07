using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace HealthZonemr.Models
{
    public class DrLogin
    {
        public string doctorid { get; set; }
        public string password { get; set; }
    }

    public class EmpLogin
    {
        public string registerno { get; set; }
        public string password { get; set; }
    }
}