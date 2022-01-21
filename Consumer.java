package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public abstract class Consumer {
    ArrayList<Consumer> knownPpl;
    Resume resume;

    static class Resume {
        Information info;
        ArrayList <Education> education;
        ArrayList<Experience> experience;

        private Resume(ResumeBuilder builder) {
            info = builder.info;
            education = builder.education;
            experience = builder.experience;
        }

        Double yearsExperience () {
            Double yrs = 0d;
            Iterator itty = experience.iterator();
            Experience exp;

            while (itty.hasNext()){
                exp = (Experience) itty.next();
                if (exp.dateEnd != null) {
                    double days = Period.between(exp.dateBegin, exp.dateEnd).getDays();
                    yrs += days / 365;
                }
            }
            yrs = Math.ceil(yrs);
            return yrs;
        }

       public static class ResumeBuilder {
            Information info;
            ArrayList <Education> education;
            ArrayList<Experience> experience;

            public ResumeBuilder()  {
                this.info = new Information();
                education = new ArrayList <Education> ();
                experience = new ArrayList<Experience> ();
            }

            public ResumeBuilder numePrenume (String nume, String prenume) {
                this.info.setNumePrenume(nume, prenume);
                return this;
            }

           public ResumeBuilder email (String email) {
               this.info.setEmail(email);
               return this;
           }

           public ResumeBuilder telefon (String telefon) {
               this.info.setTelefon(telefon);
               return this;
           }

           public ResumeBuilder dataNastere (String dataNastere) {
               this.info.setDataNastere(dataNastere);
               return this;
           }

           public ResumeBuilder sex (String sex) {
               this.info.setSex(sex);
               return this;
           }


            public ResumeBuilder education(ArrayList<Education> education) {
                this.education = education;
                return this;
            }

           public ResumeBuilder education( Education education) {
               this.education.add(education);
               return this;
           }

            public ResumeBuilder experience(ArrayList<Experience> experience) {
                this.experience = experience;
                return this;
            }

           public ResumeBuilder experience(Experience experience) {
               this.experience.add(experience);
               return this;
           }

            public Resume build() throws ResumeIncompleteException {
                if (education.size()< 1)
                    throw new ResumeIncompleteException();
                if (info == null)
                    throw new ResumeIncompleteException();

                return new Resume (this);
            }

        }

        @Override
        public String toString() {
            return "Resume{" +
                    "info=" + info +
                    ", education=" + education +
                    ", experience=" + experience +
                    '}';
        }
    }

    public Consumer() {
        knownPpl = new ArrayList<Consumer>();
    }
    public void add(Education education) {
        resume.education.add(education);
        Collections.sort(resume.education);
    }

    public void add(Experience experience) {
        resume.experience.add(experience);
        Collections.sort(resume.experience);
    }

    public int getDegreeInFriendship(Consumer consumer) {
        // utilizez un hashtable pentru a stoca stadiul de vizitare precum si gradul de prietenie
          Hashtable<Consumer, Integer> visited = new Hashtable<Consumer, Integer>();
          ArrayList<Consumer> people = new ArrayList<Consumer>(); // am simulat o coada cu un arraylist deoarece
         // metodele imi erau mai familiare

          people.add(this); // adaug utilizatorul curent in "coada"
          visited.put(this, 0);
          Consumer current;
          Integer nextDepth;

          while (!people.isEmpty()) {
              current = people.get(0);
              nextDepth = visited.get(current) + 1; // adancimea este setata la cea curenta + 1

              Iterator itty = current.knownPpl.iterator();
              Consumer tryCons;

              while (itty.hasNext()) {
                  tryCons = (Consumer) itty.next();

                  if (tryCons.equals(consumer)) {
                      return nextDepth;
                  }
                  // daca cheia este continuta in hastable atunci nodul este deja vizitat
                  else if(!visited.containsKey(tryCons)) {
                      visited.put(tryCons, nextDepth);
                      people.add(tryCons);
                  }
              }
              people.remove(0);
          }
          return Integer.MAX_VALUE; // consumer nu a fost gasit in reteaua utilizatorului
    }

    public void remove (Consumer consumer) {
        knownPpl.remove(consumer);
    }

    public Integer getGraduationYear() {
        return resume.education.get(resume.education.size() - 1).dateEnd.getYear();
    }

    public Double meanGPA() {
        Double GPA = 0d;
        Double nrDegrees = 0d;
        Iterator itty = resume.education.iterator();
        Education edu;

        while (itty.hasNext()){
            edu = (Education) itty.next();
            GPA += edu.medieAbsolvire;
            nrDegrees += 1;
        }

        return GPA/nrDegrees;
    }
}
