package upc.edu.pe.webdevs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detailArtistEvent")
public class DetailArtistEvent implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer detailId;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	private Artist artistDetail;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event eventDetail;

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public Artist getArtistDetail() {
		return artistDetail;
	}

	public void setArtistDetail(Artist artistDetail) {
		this.artistDetail = artistDetail;
	}

	public Event getEventDetail() {
		return eventDetail;
	}

	public void setEventDetail(Event eventDetail) {
		this.eventDetail = eventDetail;
	}
	
	
}
