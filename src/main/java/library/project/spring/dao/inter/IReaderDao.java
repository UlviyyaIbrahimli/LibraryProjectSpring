package library.project.spring.dao.inter;

import library.project.spring.model.Reader;
import library.project.spring.request.ReqUser;

public interface IReaderDao {
    Integer getRegistrationReaderCount() throws Exception;
    Reader checkReader(ReqUser reqUser) throws Exception;
   void createNewReader(Reader reader) throws Exception;
}
