package com.company;

public class Recruiter extends Employee {
    Double rating = 5d;

    // am modificat headerul deoarece cerinta parea imposibil de realizat
    public Double evaluate(Job job, User user) {
        Double eval = rating * user.getTotalScore();
        Request<Job, Consumer> req = new Request<Job, Consumer>(job, user, this, eval);

        Application singleton = Application.getInstance();
        singleton.getCompany(this.getCompanyName()).manager.requests.add(req);

        rating += 0.1;
        return  eval;
    }
}
