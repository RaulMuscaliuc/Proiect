import React from 'react';
import styled from "styled-components";
import './SideNav.css'
import NavItem from "../items/NavItem";
import Pacienti from "../../pacienti/Pacienti";

const StyledSideNav = styled.div``;

class SideNav extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            activePath: '/',
        }
    }

    onItemClick = (path) => {
        this.setState({activePath: path}); /* Sets activePath which causes rerender which causes CSS to change */
    };

    render() {
        let role = "";
        let id;
        if (localStorage.length === 1) {
            role = JSON.parse(localStorage.getItem('user')).role;
            id = JSON.parse(localStorage.getItem('user')).id;
        }
        return (
            <StyledSideNav className='sideBar'>
                <NavItem path='/' name='Home' css='fa fa-fw fa-home' onItemClick={this.onItemClick} key='1'/>
                {role === "admin" ? <NavItem path='/inregistrare' name='Inregistrare' css='fa fa-address-book'
                                             onItemClick={this.onItemClick} key='3'/> :
                    <NavItem path={role === 'pacient' ? '/pacienti/' + id : '/pacienti'}
                             name='Home' css='fas fa-archive' onItemClick={this.onItemClick} key='2'/>
                }
                {role === "medic" ? <NavItem path="/pacienti/adaugare"
                                             name='Home' css='fa fa-address-book' onItemClick={this.onItemClick} key='3'/> : ""}

            </StyledSideNav>
        );
    }
}

export default class Sidebar extends React.Component {
    render() {
        return (
            <SideNav></SideNav>
        );
    }
}
