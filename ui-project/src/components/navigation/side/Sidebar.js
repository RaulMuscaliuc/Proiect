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
            items: [
                {
                    path: '/', /* path is used as id to check which NavItem is active basically */
                    name: 'Home',
                    css: 'fa fa-fw fa-home',
                    key: 1, /* Key is required, else console throws error. Does this please you Mr. Browser?! */
                },
                {
                    path: '/pacienti',
                    name: 'Lista pacienti',
                    css: 'fas fa-archive',
                    key: 2,
                },
            ]
        }
    }

    onItemClick = (path) => {
        this.setState({activePath: path}); /* Sets activePath which causes rerender which causes CSS to change */
    };

    render() {
        let role = "";
        let id;
        if(localStorage.length === 1) {
            role = JSON.parse(localStorage.getItem('user')).role;
            id = JSON.parse(localStorage.getItem('user')).id;
        }
        return (
            <StyledSideNav className='sideBar'>
                <NavItem path='/' name='Home' css='fa fa-fw fa-home' onItemClick={this.onItemClick} key='1'/>
                <NavItem path={role === 'pacient' ? '/pacienti/' + id : '/pacienti'}
                         name='Home' css='fas fa-archive' onItemClick={this.onItemClick} key='1'/>
                )
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
