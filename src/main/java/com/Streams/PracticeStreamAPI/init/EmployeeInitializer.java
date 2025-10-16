package com.Streams.PracticeStreamAPI.init;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import com.Streams.PracticeStreamAPI.domain.Employee;
import com.Streams.PracticeStreamAPI.repository.EmployeeRepo;

public class EmployeeInitializer {

        private final static Random random = new Random();

        public static void Initializer(EmployeeRepo employeeRepo) {

                System.out.println("DataInitializer run method executed");

                String[] departments = { "HR", "Finance", "IT", "Sales", "Digital Marketing", "Operations",
                                "Customer Service",
                                "R&D", "Legal", "Admin" };
                String[] names = {
                                "Aarav", "Vihaan", "Vivaan", "Aditya", "Arjun", "Reyansh", "Muhammad", "Sai", "Arnav",
                                "Ayaan",
                                "Krishna", "Ishaan", "Rohan", "Dhruv", "Kabir", "Rudra", "Anay", "Atharv", "Shivansh",
                                "Kian",
                                "Ananya", "Aadhya", "Diya", "Ira", "Myra", "Sara", "Pari", "Anika", "Navya", "Saanvi",
                                "Aarohi", "Avni", "Meera", "Riya", "Ishita", "Kiara", "Nisha", "Tanvi", "Sneha",
                                "Priya",
                                "Neha", "Simran", "Pooja", "Kritika", "Sakshi", "Shreya", "Aisha", "Manvi", "Tara",
                                "Nidhi"
                };

                String[] cities = {
                                "Mumbai", "Delhi", "Bengaluru", "Hyderabad", "Chennai", "Kolkata", "Pune", "Ahmedabad",
                                "Jaipur",
                                "Surat",
                                "Lucknow", "Kanpur", "Nagpur", "Indore", "Bhopal", "Patna", "Vadodara", "Ludhiana",
                                "Agra", "Nashik",
                                "Coimbatore", "Kochi", "Visakhapatnam", "Varanasi", "Amritsar", "Meerut", "Rajkot",
                                "Ranchi",
                                "Guwahati", "Chandigarh",
                                "Mysuru", "Thiruvananthapuram", "Jodhpur", "Madurai", "Raipur", "Aurangabad",
                                "Jamshedpur", "Dehradun",
                                "Udaipur", "Gwalior",
                                "Noida", "Faridabad", "Ghaziabad", "Vijayawada", "Tiruchirappalli", "Salem", "Warangal",
                                "Bhavnagar",
                                "Jabalpur", "Bilaspur"
                };

                String[] skills = {
                                "Java", "Spring Boot", "MySQL", "Hibernate", "REST APIs",
                                "HTML", "CSS", "JavaScript", "React", "Git",
                                "Docker", "Kubernetes", "AWS", "Microservices", "JPA",
                                "Python", "C++", "Angular", "Node.js", "MongoDB",
                                "Jenkins", "Maven", "Gradle", "Linux", "PostgreSQL",
                                "TypeScript", "JSON", "Bootstrap", "Redis", "Kafka",
                                "Testing", "JUnit", "Mockito", "Agile", "DevOps",
                                "CI/CD", "Problem Solving", "Communication", "Data Structures",
                                "Algorithms", "Machine Learning", "Data Analysis", "API Design",
                                "NoSQL", "Oracle", "React Native", "Express.js", "Firebase", "Tailwind CSS"
                };

                String[] jobTitles = {
                                "Software Engineer", "Senior Software Engineer", "Lead Developer", "Project Manager",
                                "Business Analyst", "Quality Assurance Engineer", "DevOps Engineer",
                                "System Administrator",
                                "Database Administrator", "Network Engineer", "IT Support Specialist", "Data Scientist",
                                "Machine Learning Engineer", "Full Stack Developer", "Frontend Developer",
                                "Backend Developer",
                                "Mobile App Developer", "Cloud Solutions Architect", "Cybersecurity Analyst",
                                "Technical Writer"
                };

                String[] educationLevels = {
                                "High School Diploma", "Associate Degree", "Bachelor's Degree", "Master's Degree",
                                "Doctorate (Ph.D.)", "Professional Certification"
                };

                String[] genders = { "Male", "Female", "Other" };

                String[] managerNames = {
                                "Rahul Sharma", "Anita Desai", "Vikram Singh", "Pooja Mehta", "Suresh Kumar",
                                "Neha Gupta", "Amit Joshi", "Kavita Reddy", "Rakesh Patel", "Sunita Nair"
                };

                String[] projectNames = {
                                "Project Alpha", "Project Beta", "Project Gamma", "Project Delta", "Project Epsilon",
                                "Project Zeta", "Project Eta", "Project Theta", "Project Iota", "Project Kappa"
                };

                String[] workLocations = { "Onsite", "Remote", "Hybrid" };
                String[] employmentTypes = { "Full-time", "Part-time", "Contract", "Internship" };
                String[] shifts = { "Day", "Night", "Rotational" };
                String[] teams = { "Alpha", "Beta", "Gamma", "Delta", "Epsilon" };

                String[] countries = {
                                "India", "United States", "United Kingdom", "Canada", "Australia",
                                "Germany", "France", "Italy", "Spain", "Netherlands",
                                "Switzerland", "Japan", "China", "South Korea", "Singapore",
                                "Brazil", "Mexico", "Russia", "South Africa", "New Zealand",
                                "Sweden", "Norway", "Denmark", "UAE", "Saudi Arabia"
                };

                String[] states = {
                                "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
                                "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
                                "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
                                "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
                                "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Uttar Pradesh"
                };

                String[] addresses = {
                                "123 Main St", "456 Oak Ave", "789 Pine Rd", "101 Maple Dr", "202 Birch Ln",
                                "303 Cedar Ct", "404 Spruce St", "505 Elm St", "606 Walnut Ave", "707 Chestnut Rd",
                                "808 Ash Dr", "909 Poplar Ln", "111 Willow Ct", "222 Fir St", "333 Cypress Ave",
                                "444 Magnolia Rd", "555 Palm Dr", "666 Dogwood Ln", "777 Hickory Ct", "888 Sycamore St"
                };

                String[] companies = {
                                "Tata Consultancy Services", "Infosys", "Wipro", "HCL Technologies", "Tech Mahindra",
                                "Larsen & Toubro Infotech", "Cognizant", "IBM India", "Capgemini", "Accenture",
                                "Oracle India", "Dell Technologies", "Microsoft India", "Google India", "Amazon India",
                                "Flipkart", "Mindtree", "Mphasis", "Persistent Systems", "Hexaware Technologies",
                                "Qualcomm India", "Samsung R&D", "Adobe India", "Intel India", "HP India",
                                "Cisco Systems India", "VMware India", "Siemens India", "Bosch India", "Adobe India",
                                "Sony India", "Mahindra & Mahindra", "Uber India", "Zomato", "Swiggy",
                                "Paytm", "PhonePe", "Byju's", "Ola", "Reliance Jio",
                                "Maruti Suzuki", "Hero MotoCorp", "Infosys BPM", "Bajaj Auto", "Vedanta",
                                "L&T Technology Services", "Axis Bank", "ICICI Bank", "HDFC Bank", "State Bank of India"
                };

                String[] emailProviders = { "gmail.com", "yahoo.com", "outlook.com", "example.com", "mail.com" };

                String email = names[random.nextInt(names.length)].toLowerCase()
                                + (100 + random.nextInt(900)) + "@"
                                + emailProviders[random.nextInt(emailProviders.length)];

                boolean isBoolean = random.nextBoolean();

                for (int i = 0; i < 1000; i++) {

                        LocalDate startDate = LocalDate.now().minusYears(10);
                        LocalDate endDate = LocalDate.now();

                        // Random joining date in the last 10 years
                        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
                        LocalDate randomDateJoiningDate = startDate.plusDays(random.nextInt((int) daysBetween + 1));

                        // Random DOB: age between 22 and 46
                        int ageYears = 22 + random.nextInt(25);
                        LocalDate randomDob = randomDateJoiningDate.minusYears(ageYears)
                                        .minusDays(random.nextInt(365));

                        int age = (int) ChronoUnit.YEARS.between(randomDob, LocalDate.now());

                        // Years of experience: joining age minus 22 (minimum 0)
                        int yearsOfExperience = (int) ChronoUnit.YEARS.between(randomDob, randomDateJoiningDate) - 22;
                        if (yearsOfExperience < 0) {
                                yearsOfExperience = 0;
                        }

                        // Random 10-digit phone number
                        long phoneLong = Math.abs(random.nextLong() % 1_000_000_0000L); // 0 to 9999999999
                        String phoneNumber = String.format("%010d", phoneLong);


                        // Creating the Employeess
                        Employee employee = new Employee();
                        employee.setName(names[random.nextInt(names.length)]);
                        employee.setDepartment(departments[random.nextInt(departments.length)]);
                        employee.setSalary(30000 + (150000 - 30000) * random.nextDouble());
                        employee.setDob(randomDob != null ? java.sql.Date.valueOf(randomDob) : null);
                        employee.setJoiningDate(
                                        randomDateJoiningDate != null ? java.sql.Date.valueOf(randomDateJoiningDate)
                                                        : null);
                        employee.setAge(age);
                        employee.setCity(cities[random.nextInt(cities.length)]);
                        employee.setGender(genders[random.nextInt(genders.length)]);
                        employee.setYearsOfExperience(yearsOfExperience);
                        employee.setJobTitle(jobTitles[random.nextInt(jobTitles.length)]);
                        employee.setEducationLevel(educationLevels[random.nextInt(educationLevels.length)]);
                        employee.setFullTime(isBoolean);
                        employee.setMarried(isBoolean);
                        employee.setPhoneNumber(phoneNumber);
                        employee.setEmail(email);
                        employee.setAddress(addresses[random.nextInt(addresses.length)]);
                        employee.setCountry(countries[random.nextInt(countries.length)]);
                        employee.setState(states[random.nextInt(states.length)]);
                        employee.setActive(isBoolean);
                        employee.setManagerName(managerNames[random.nextInt(managerNames.length)]);
                        employee.setSkills(skills[random.nextInt(skills.length)]);
                        employee.setProjectName(projectNames[random.nextInt(projectNames.length)]);
                        employee.setPerformanceRating(1 + random.nextInt(5));
                        employee.setBonus(1000 + (10000 - 1000) * random.nextDouble());
                        employee.setWorkLocation(workLocations[random.nextInt(workLocations.length)]);
                        employee.setEmploymentType(employmentTypes[random.nextInt(employmentTypes.length)]);
                        employee.setShift(shifts[random.nextInt(shifts.length)]);
                        employee.setTeam(teams[random.nextInt(teams.length)]);
                        employee.setJobTitle(jobTitles[random.nextInt(jobTitles.length)]);
                        employee.setEducationLevel(educationLevels[random.nextInt(educationLevels.length)]);
                        employee.setSkills(skills[random.nextInt(skills.length)]);
                        employee.setEmployeeId("EMP" + String.format("%05d", i + 1));
                        employee.setCompanyName(companies[random.nextInt(companies.length)]);
                        employeeRepo.save(employee);
                }

        }

}
