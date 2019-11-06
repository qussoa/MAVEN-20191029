package com.biz.sec.persistence;

import com.biz.sec.persistence.MasterDTO.MasterDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailDTO {
	private long d_seq;//	number
	private long d_nseq;//	number
	private String d_subject;//	nvarchar2(1000 char)
	private String d_ok;//	varchar2(1 byte)
}
