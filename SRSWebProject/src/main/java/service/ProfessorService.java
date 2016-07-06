package service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProfessorDao;
import dao.dataAcess;
import model.Professor;

public class ProfessorService {
	public String getAllProfessorsJSON() {
		JSONArray ja = new JSONArray();

		ProfessorDao pd = dataAcess.createProfessorDao();
		List<Professor> professors = pd.getAllProfessors();

		for (Professor p : professors) {
			JSONObject jo = new JSONObject();
			jo.put("Pssn", p.getSsn());
			jo.put("name", p.getName());
			jo.put("title", p.getTitle());
			jo.put("department", p.getDepartment());
			ja.put(jo);
		}
		return ja.toString();
	}

	public String getProfessorJSON(String Pssn) {
		JSONObject jo = new JSONObject();

		ProfessorDao pd = dataAcess.createProfessorDao();
		Professor professor = pd.getProfessor(Pssn);
		jo.put("Pssn", professor.getSsn());
		jo.put("name", professor.getName());
		jo.put("title", professor.getTitle());
		jo.put("department", professor.getDepartment());

		return jo.toString();
	}
	
	public void addProfessor(String professorName,String pssn,String title,String department){
		Professor p=new Professor(professorName, pssn, title, department);
		ProfessorDao pd=dataAcess.createProfessorDao();
		pd.addProfessor(p);
	}
	
	public void deleteProfessor(String pssn){
		ProfessorDao pd=dataAcess.createProfessorDao();
		pd.deleteProfessor(pssn);
	}
	
	public void updateProfessor(Professor professor){
		ProfessorDao pd=dataAcess.createProfessorDao();
		pd.updateProfessor(professor);
	}
}
