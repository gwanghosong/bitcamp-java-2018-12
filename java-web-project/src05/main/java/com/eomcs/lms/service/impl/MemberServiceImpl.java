package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {

  MemberDao memberDao;

  public MemberServiceImpl(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public List<Member> list(String kewword) {

    if (kewword != null) 
      return memberDao.findByKeyword(kewword);
    else
      return memberDao.findAll();
  }

  @Override
  public int add(Member member) {
    return memberDao.insert(member);
  }

  @Override
  public Member get(int no) {
    Member member = memberDao.findByNo(no);
    return member;
  }

  @Override
  public int update(Member member) {
    return memberDao.update(member);
  }

  @Override
  public int delete(int no) {
    return memberDao.delete(no);
  }

  @Override
  public Member get(String email, String password) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);
    
    return memberDao.findByEmailPassword(paramMap);
  }
}
