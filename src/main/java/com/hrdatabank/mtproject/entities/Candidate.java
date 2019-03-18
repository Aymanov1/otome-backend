package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Candidate.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Candidate extends UserInformation implements Serializable {

	public Candidate(HashMap<String, Object> candidate) {
		super();
		this.guest = (boolean) candidate.get("guest");
		this.phone = (String) candidate.get("phone");
		this.candidateFB = (boolean) candidate.get("candidateFB");
		this.userName = (String) candidate.get("userName");
		this.jLPT = (String) candidate.get("jLPT");
		this.userNameKatakana = (String) candidate.get("userNameKatakana");
		this.durationInJapan = (String) candidate.get("durationInJapan");
		String dateS = (String) candidate.get("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			this.birthday = sdf.parse(dateS);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public Candidate(HashMap<String, Object> candidate, HashMap<String, Object> candidateDetails) {
		super();
		this.guest = (boolean) candidate.get("guest");

		this.candidateFB = (boolean) candidate.get("candidateFB");

		this.userName = candidateDetails.get("candidateName").toString();
		this.jLPT = candidateDetails.get("candidateJLPT").toString();
		this.phone = candidateDetails.get("candidatePhone").toString();
		if (candidateDetails.get("candidateNameKatakana") == null) {
			this.userNameKatakana = "";
		} else {
			this.userNameKatakana = candidateDetails.get("candidateNameKatakana").toString();
		}
		String duration = candidateDetails.get("candidateDurationInJapan").toString();
		// if
		// (Charset.forName(CharEncoding.ISO_8859_1).newEncoder().canEncode(duration)) {
		// byte[] bytes = duration.getBytes("iso-8859-1");
		// duration = new String(bytes);
		// }
		this.durationInJapan = duration;
		// System.out.println("--www----------userName-------------:" + userName);
		// System.out.println("--www---------jLPT--------------:" + jLPT);
		// System.out.println("--www-----------phone------------:" + phone);
		// System.out.println("--www----------duration-------------:" + duration);
		// System.out.println(
		// "--www--------candidateBirthday----------:" +
		// candidateDetails.get("candidateBirthday").toString());
		// System.out.println("--www---------------candidateDetails.get(\"candidateNameKatakana\")------------------:"
		// + candidateDetails.get("candidateNameKatakana"));

		DateFormat formatterBirthday = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateBirthday = formatterBirthday.parse(candidateDetails.get("candidateBirthday").toString());
			this.birthday = dateBirthday;
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id person in charge. */
	@Column(columnDefinition = "int default 0")
	private int idPersonInCharge;

	@Column(columnDefinition = "int default 0")
	private int searchCounter;

	@Column(columnDefinition = "int default 0")
	private int suggestedCounter;

	@Column(columnDefinition = "int default 0")
	private int failedCounter;

	@Column(columnDefinition = "int default 0")
	private int applyCounter;

	/** The user line id. */
	private String userLineId;

	/** The phone. */
	private String phone;

	/** The birthday. */
	@Temporal(TemporalType.DATE)
	private Date birthday;

	/** The j LPT. */
	private String jLPT;

	/** The nearest station. */
	private String nearestStation;

	/** The workable time. */
	private String workableTime;

	/** The duration in japan. */
	private String durationInJapan;

	/** The memo. */
	private String memo;

	/** The progress. */
	private String progress;

	/** The category type to add. */
	private String categoryTypeToAdd;

	/** The reason to add. */
	private String reasonToAdd;

	/** The email. */
	private String email;

	private String firstNameFB;
	private String lastNameFB;
	private String timeZoneFB;
	private String localFB;
	private String idUserFB;

	@Column(columnDefinition = "boolean default false")
	private boolean candidateFB;

	@Column(columnDefinition = "boolean default false")
	private boolean guest;

	/** The register date. */

	private Date registerDate;

	/** The start working time. */
	@Temporal(TemporalType.TIME)
	private Date startWorkingTime;

	/** The finish working time. */
	@Temporal(TemporalType.TIME)
	private Date finishWorkingTime;

	/** The chat line admin. */
	@OneToOne
	@JoinColumn(name = "idChatLineAdmin", referencedColumnName = "idChatLineAdmin")
	private ChatLineAdmin chatLineAdmin;

	/** The job candidate relations. */
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "candidate", "job" })
	private List<JobCandidateRelation> jobCandidateRelations;

	/** The alerts. */
	@OneToMany(mappedBy = "candidate")
	private List<Alert> alerts;

	/** The candidate admin relations. */
	@OneToMany(mappedBy = "candidate")
	@JsonIgnoreProperties({ "candidate", "memos" })
	private List<CandidateAdminRelation> candidateAdminRelations;

	/** The shop candidate relations. */
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "candidate", "jobCandidateRelations", "candidateAdminRelations" })
	private List<ShopCandidateRelation> shopCandidateRelations;

	/** The bot information. */
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idBotInformation", referencedColumnName = "idBotInformation")
	@JsonIgnoreProperties("candidate")
	private BotInformation botInformation;

}
