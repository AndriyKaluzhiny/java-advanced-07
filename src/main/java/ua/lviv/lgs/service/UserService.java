package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.shared.AbstractDao;

public interface UserService extends AbstractDao<User> {
    User readByEmail(String email);
}
