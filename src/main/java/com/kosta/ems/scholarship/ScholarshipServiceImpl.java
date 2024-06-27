package com.kosta.ems.scholarship;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScholarshipServiceImpl implements ScholarshipService {

    private final ScholarshipMapper scholarshipMapper;

    @Override
    public List<ScholarshipTargetDTO> getScholarshipTargetList(ScholarshipTargetListReqDTO dto, int page, int size) {
        int limit = size;
        int offset = size * (page - 1);

        dto.setLimit(limit);
        dto.setOffset(offset);

        return (ArrayList<ScholarshipTargetDTO>) scholarshipMapper.selectScholarshipTargetList(dto.getAcademyLocation(), dto.getName(), String.valueOf(dto.getCourseNumber()), limit, offset);
    }

    @Override
    public void setScholarshipSettlementDate(int studentCourseSeq) {
        scholarshipMapper.insertScholarshipSettlementDate(studentCourseSeq);
    }

    @Override
    public List<ScholarshipSettlementResultDTO> getScholarshipSettlementResultList(ScholarshipTargetListReqDTO dto, int page, int size) {
        int limit = size;
        int offset = size * (page - 1);

        dto.setLimit(limit);
        dto.setOffset(offset);

        return (ArrayList<ScholarshipSettlementResultDTO>) scholarshipMapper.selectScholarshipSettlementResultList(String.valueOf(dto.getCourseNumber()), dto.getAcademyLocation(), dto.getName(), dto.getScholarshipDate(), limit, offset);
    }


}
